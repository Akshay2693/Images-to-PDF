package swati4star.createpdf;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.gun0912.tedpicker.ImagePickerActivity;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ViewFiles extends Fragment {



    String path;
    Activity ac;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ac = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_viewfiles,container);
        File folder = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/PDFfiles/");
        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdir();
        }

        ArrayList<String> inFiles = new ArrayList<String >();
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
            } else {
                if(file.getName().endsWith(".pdf")){
                    inFiles.add(file.getPath());

                    Log.e("adding",file.getName());

                }
            }
        }

        Files_adapter adapter = new Files_adapter(ac,inFiles);
        GridView g = (GridView) root.findViewById(R.id.list);
        g.setAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);

    }






}