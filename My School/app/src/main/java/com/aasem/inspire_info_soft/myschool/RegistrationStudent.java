package com.aasem.inspire_info_soft.myschool;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.aasem.inspire_info_soft.myschool.CustomView.EditText.EditText;
import com.aasem.inspire_info_soft.myschool.Utill.Constants;
import com.aasem.inspire_info_soft.myschool.Utill.FileUtil;
import com.aasem.inspire_info_soft.myschool.Utill.Utility;
import com.aasem.inspire_info_soft.myschool.Utill.Validation;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.fxn.cue.Cue;
import com.fxn.cue.enums.Type;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import id.zelory.compressor.Compressor;
import static com.basgeekball.awesomevalidation.ValidationStyle.COLORATION;

public class RegistrationStudent extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etFatherName, etMotherName, etContactNumber, etBloodGroup, etAdhaarNumber, etAddress, etRegistrationNumber, etClass, etDivision, etRollNumber;
    EditText etPassword, etConformPassword, etAdmissionDate,etFatherContactNumber,etCast,etReligion,etState,etNationality;
    Switch switchGender;
    String image;
    TextView tvDOB;
    Button btnSubmit;
    int selected = 0;
    RequestQueue requestQueue;
    Spinner sp_blood_group;
    ProgressDialog progressDialog;
    Calendar myCalendar = Calendar.getInstance();
    ImageView iv_camera, iv_gallery;
    private int PICK_IMAGE_REQUEST = 1;
    private int REQUEST_CAMERA = 2;
    public static ImageView iv_dp;
    public static boolean isImageSet = false;
    private File actualImage;
    private File compressedImage;
    boolean flag = false;
    private Bitmap bitmap;
    private AwesomeValidation mAwesomeValidation;
    //  final String URL = "http://192.168.1.105:81/test_my_school/reg.php";
    // String URL = "http://globalinstacare.com/test_my_school/demo.php";
    String URL = com.aasem.inspire_info_soft.myschool.Utill.URL.Registration;
    int selected_gallery = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
        addValidation();

        requestQueue = Volley.newRequestQueue(RegistrationStudent.this);
    }

    private void init() {
        iv_camera = (ImageView) findViewById(R.id.iv_camera);
        iv_gallery = (ImageView) findViewById(R.id.iv_gallery);
        etName = (EditText) findViewById(R.id.et_name);
        tvDOB = (TextView) findViewById(R.id.et_date);
        etFatherName = (EditText) findViewById(R.id.et_father_name);
        etMotherName = (EditText) findViewById(R.id.et_mother_name);
        etBloodGroup = (EditText) findViewById(R.id.et_blood_group);
        etAdhaarNumber = (EditText) findViewById(R.id.et_adhaar);
        etAddress = (EditText) findViewById(R.id.et_address);
        etRegistrationNumber = (EditText) findViewById(R.id.et_registration_no);
        etClass = (EditText) findViewById(R.id.et_class);
        etDivision = (EditText) findViewById(R.id.et_division);
        etRollNumber = (EditText) findViewById(R.id.et_roll_no);

        etFatherContactNumber = (EditText) findViewById(R.id.et_father_contact_no);
        etCast = (EditText) findViewById(R.id.et_cast);
        etReligion = (EditText) findViewById(R.id.et_religion);
        etState = (EditText) findViewById(R.id.et_state);
        etNationality = (EditText) findViewById(R.id.et_nationality);

        etContactNumber = (EditText) findViewById(R.id.et_contact_no);
        etPassword = (EditText) findViewById(R.id.et_password);
        etConformPassword = (EditText) findViewById(R.id.et_conform_password);
        etAdmissionDate = (EditText) findViewById(R.id.et_addmission_date);
        sp_blood_group = (Spinner) findViewById(R.id.sp_blood_group);
        iv_dp = (ImageView) findViewById(R.id.iv_dp);
        switchGender = (Switch) findViewById(R.id.sw_gender);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
        tvDOB.setOnClickListener(this);
        iv_camera.setOnClickListener(this);
        iv_gallery.setOnClickListener(this);
        switchGender.setOnClickListener(this);
        etAdmissionDate.setOnClickListener(this);
        progressDialog = new ProgressDialog(RegistrationStudent.this);
        switchGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    switchGender.setText("Male");
                    if (!isImageSet) {
                        iv_dp.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.ic_user_male));
                    }
                } else {
                    switchGender.setText("Female");
                    if (!isImageSet) {
                        iv_dp.setImageDrawable(getApplicationContext().getResources().getDrawable(R.drawable.ic_user_female));
                    }
                }
            }
        });
    }

    private void addValidation() {
        mAwesomeValidation = new AwesomeValidation(COLORATION);
        mAwesomeValidation.setColor(Color.YELLOW);
        mAwesomeValidation.addValidation(RegistrationStudent.this, R.id.et_name, "[a-zA-Z\\s]+", R.string.error_name);
        mAwesomeValidation.addValidation(RegistrationStudent.this, R.id.et_father_name, "[a-zA-Z\\s]+", R.string.error_name);
        mAwesomeValidation.addValidation(RegistrationStudent.this, R.id.et_mother_name, "[a-zA-Z\\s]+", R.string.error_name);
        mAwesomeValidation.addValidation(RegistrationStudent.this, R.id.et_roll_no, RegexTemplate.TELEPHONE, R.string.err_tel);
        mAwesomeValidation.addValidation(RegistrationStudent.this, R.id.et_contact_no, RegexTemplate.TELEPHONE, R.string.err_tel);
        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        mAwesomeValidation.addValidation(RegistrationStudent.this, R.id.et_password, regexPassword, R.string.err_password);
        mAwesomeValidation.addValidation(RegistrationStudent.this, R.id.et_conform_password, R.id.et_password, R.string.err_password_confirmation);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_submit:
                if(isNetworkAvailable()){
                if (mAwesomeValidation.validate()) {
                    submitData();
                } else {
                    Cue.init()
                            .with(RegistrationStudent.this)
                            .setGravity(Gravity.BOTTOM)
                            .setMessage("Please enter all valid details")
                            .setType(Type.DANGER)
                            .show();
                }}else {
                    Cue.init()
                            .with(RegistrationStudent.this)
                            .setGravity(Gravity.BOTTOM)
                            .setMessage("Please check your internet connection and try again !")
                            .setType(Type.DANGER)
                            .show();
                }
                break;

            case R.id.et_date:
                openDatePicker();
                break;

            case R.id.iv_camera:
                selected_gallery = 2;
                if (isPermissionGranted())
                    openCamera();
                break;

            case R.id.iv_gallery:
                selected_gallery = 1;
                if (isPermissionGranted())
                    openGallery();
                break;

            case R.id.et_addmission_date:
                openDatePicker_Admission();
                break;
        }
    }


    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    private void submitData() {
        progressDialog.setMessage("Please Wait, We are registering you.. ");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                if (response != null && response.length() > 0) {
                    Cue.init()
                            .with(RegistrationStudent.this)
                            .setGravity(Gravity.BOTTOM)
                            .setMessage("Registration Successfully")
                            .setType(Type.PRIMARY)
                            .show();
                } else {
                    Cue.init()
                            .with(RegistrationStudent.this)
                            .setGravity(Gravity.BOTTOM)
                            .setMessage("Blank Respones")
                            .setType(Type.DANGER)
                            .show();

                }
                finish();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {


                        progressDialog.dismiss();
                        Cue.init()
                                .with(RegistrationStudent.this)
                                .setGravity(Gravity.BOTTOM)
                                .setMessage(volleyError.getMessage())
                                .setType(Type.DANGER)
                                .show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json");
                String name = etName.getText1();
                String fatherName = etFatherName.getText1();
                String motherName = etMotherName.getText1();
                String bloodGroup = sp_blood_group.getSelectedItem().toString();
                String adhaarNumber = etAdhaarNumber.getText1();
                String address = etAddress.getText1();
                String registrationNumber = etRegistrationNumber.getText1();
                String classs = etClass.getText1();
                String contact_number = etContactNumber.getText1();
                String division = etDivision.getText1();
                String rollNumber = etRollNumber.getText1();
                String date_of_birth = tvDOB.getText().toString();

                String father_contact_number = etFatherContactNumber.getText().toString();
                String cast = etCast.getText().toString();
                String religion = etReligion.getText().toString();
                String state = etState.getText().toString();
                String nationality = etNationality.getText().toString();

                String user_type= Constants.USER_STUDENT;


                if (Validation.isEmptyorNull(date_of_birth)) {
                    date_of_birth = "";
                }
                String gender = switchGender.getText().toString();

                String password = etPassword.getText1();
                String admission_date = etAdmissionDate.getText1();
                params.put("user_type", user_type);
                params.put("name", name);
                params.put("father_name", fatherName);
                params.put("mother_name", motherName);
                params.put("blood_group", bloodGroup);
                params.put("adhaar_number", adhaarNumber);
                params.put("address", address);
                params.put("registration_number", registrationNumber);
                params.put("class", classs);
                params.put("division", division);
                params.put("roll_number", rollNumber);
                params.put("contact_number", contact_number);
                params.put("father_contact_number", father_contact_number);
                params.put("dob", date_of_birth);
                params.put("cast", cast);
                params.put("religion", religion);
                params.put("state", state);
                params.put("nationality", nationality);
                params.put("gender", gender);
                params.put("admission_date", admission_date);
                params.put("password", password);
                params.put("image", getStringImage(bitmap));
                return checkParams(params);
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(RegistrationStudent.this);
        requestQueue.add(stringRequest);
    }

    private Map<String, String> checkParams(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pairs = (Map.Entry<String, String>) it.next();
            if (pairs.getValue() == null) {
                map.put(pairs.getKey(), "");
            }
        }
        return map;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            try {
                actualImage = FileUtil.from(this, data.getData());
                compressedImage = new Compressor(this)
                        .setMaxWidth(300)
                        .setMaxHeight(300)
                        .setQuality(90)
                        .setCompressFormat(Bitmap.CompressFormat.WEBP)
                        .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_PICTURES).getAbsolutePath())
                        .compressToFile(actualImage);
                setCompressedImage();
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(compressedImage));

                iv_dp.setImageBitmap(BitmapFactory.decodeFile(compressedImage.getAbsolutePath()));
                flag = true;
            } catch (IOException e) {
                iv_dp.setImageBitmap(BitmapFactory.decodeFile(actualImage.getAbsolutePath()));
                flag = true;
                Toast.makeText(RegistrationStudent.this, "Failed to read picture data!", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        } else if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK && data != null && data.getExtras().get("data") != null) {
            bitmap = (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
            File destination = new File(Environment.getExternalStorageDirectory(),
                    System.currentTimeMillis() + ".jpg");
            FileOutputStream fo;
            try {
                destination.createNewFile();
                fo = new FileOutputStream(destination);
                fo.write(bytes.toByteArray());
                fo.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            iv_dp.setImageBitmap(bitmap);
            flag = true;
        }
    }

    private void setCompressedImage() {
        iv_dp.setImageBitmap(BitmapFactory.decodeFile(compressedImage.getAbsolutePath()));
        Log.d("Compressor", "Compressed image save in " + compressedImage.getPath());
    }

    private void openGallery() {
        selected = 1;
        boolean result = Utility.checkPermission(RegistrationStudent.this);
        if (result) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);//
            startActivityForResult(Intent.createChooser(intent, "Select File"), PICK_IMAGE_REQUEST);
        }
    }

    private void openCamera() {
        boolean result = Utility.checkPermission(RegistrationStudent.this);
        if (result) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_CAMERA);
        }
    }

    private void openDatePicker() {
        DatePickerDialog dialog = new DatePickerDialog(RegistrationStudent.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));
        dialog.getDatePicker().setMaxDate(new Date().getTime());
        dialog.show();
    }


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            tvDOB.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
        }
    };

    public boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else {
            return true;
        }
    }

    private void openDatePicker_Admission() {
        DatePickerDialog dialog = new DatePickerDialog(RegistrationStudent.this, date1, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));
        dialog.getDatePicker().setMaxDate(new Date().getTime());
        dialog.show();
    }


    DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            etAdmissionDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
        }
    };

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

