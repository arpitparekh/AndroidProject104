package com.arpitparekh.jan12androidproject.registration_full;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.arpitparekh.jan12androidproject.databinding.ActivityFullRegistrationBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.net.URI;

public class FullRegistrationActivity extends AppCompatActivity {

    private ActivityFullRegistrationBinding binding;
    private FirebaseAuth auth;
    private DatabaseReference databaseReference; // realtime database
    private StorageReference storageReference;  // storage
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFullRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("userData");

        ActivityResultLauncher<String> launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                binding.ivProfile.setImageURI(result);

                imageUri = result;
            }
        });

        binding.ivProfile.setOnClickListener(view -> {

            launcher.launch("image/*");

        });

        binding.btnSubmit.setOnClickListener(view -> {

            String name = binding.edtName.getText().toString();
            String email = binding.edtEmail.getText().toString();
            String address = binding.edtAddress.getText().toString();
            String phone = binding.edtPhone.getText().toString();
            String password = binding.edtPassword.getText().toString();
            String repeat = binding.edtRepeat.getText().toString();

            if(!name.isEmpty() && !email.isEmpty() && !address.isEmpty() && !phone.isEmpty() && !password.isEmpty() && !repeat.isEmpty() && imageUri!=null){

                auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        String uid = auth.getCurrentUser().getUid();

                        storageReference = FirebaseStorage.getInstance().getReference("userImage").child(uid);

                        storageReference.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {

                                        String url = uri.toString();

                                        User user = new User(email,uid,url,phone,address,name);

                                        databaseReference.push().setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Toast.makeText(FullRegistrationActivity.this, "Success", Toast.LENGTH_SHORT).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.i("realtime",e.getMessage());
                                            }
                                        });

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.i("url",e.getMessage());
                                    }
                                });

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.i("imageUpload",e.getMessage());
                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("auth",e.getMessage());
                    }
                });

            }else{

                Toast.makeText(this, "Empty Field", Toast.LENGTH_SHORT).show();

            }

        });

    }
}