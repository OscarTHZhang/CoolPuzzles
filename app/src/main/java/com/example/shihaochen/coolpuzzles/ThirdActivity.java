package com.example.shihaochen.coolpuzzles;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.Random;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener, View.OnDragListener, View.OnTouchListener{

    private int intWidth=200;
    private int intHeight=200; // each piece is 200*200
    private int ScreenX=1440;
    private int ScreenY=2880; // the size of the screen

    private ArrayList<ImageView> imagePieces; // the array that stores an arrayList of images
    private ImageView originalImage; // the original image to make the puzzle
    private TableLayout layout; // the layout of the activity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ImageView piece1 = (ImageView) findViewById(R.id.piece1);
        ImageView piece2 = (ImageView) findViewById(R.id.piece2);
        ImageView piece3 = (ImageView) findViewById(R.id.piece3);
        ImageView piece4 = (ImageView) findViewById(R.id.piece4);
        ImageView piece5 = (ImageView) findViewById(R.id.piece5);
        ImageView piece6 = (ImageView) findViewById(R.id.piece6);
        ImageView piece7 = (ImageView) findViewById(R.id.piece7);
        ImageView piece8 = (ImageView) findViewById(R.id.piece8);
        ImageView piece9 = (ImageView) findViewById(R.id.piece9);

        this.originalImage = SecondActivity.getmHeader_iv();
        this.imagePieces = new ArrayList<>();

        ImageSplit split = new ImageSplit(this.originalImage, 3);
        ArrayList<Bitmap> bitmaps = split.getImagePieces();
        piece1.setImageBitmap(bitmaps.get(0));
        piece2.setImageBitmap(bitmaps.get(1));
        piece3.setImageBitmap(bitmaps.get(2));
        piece4.setImageBitmap(bitmaps.get(3));
        piece5.setImageBitmap(bitmaps.get(4));
        piece6.setImageBitmap(bitmaps.get(5));
        piece7.setImageBitmap(bitmaps.get(6));
        piece8.setImageBitmap(bitmaps.get(7));
        piece9.setImageBitmap(bitmaps.get(8));

        /*
        View[][] iv = splitPhoto();
        TableLayout tl = (TableLayout) findViewById(R.id.tableLayout);
        LayoutArray la = new LayoutArray(tl);
        la.isMatch(iv);
        */
        this.imagePieces.add(piece1);
        this.imagePieces.add(piece2);
        this.imagePieces.add(piece3);
        this.imagePieces.add(piece4);
        this.imagePieces.add(piece5);
        this.imagePieces.add(piece6);
        this.imagePieces.add(piece7);
        this.imagePieces.add(piece8);
        this.imagePieces.add(piece9);

        piece1.setOnDragListener(this);
        piece1.setOnClickListener(this);
        piece1.setOnTouchListener(this);


        piece2.setOnDragListener(this);
        piece2.setOnClickListener(this);
        piece2.setOnTouchListener(this);


        piece3.setOnDragListener(this);
        piece3.setOnClickListener(this);
        piece3.setOnTouchListener(this);


        piece4.setOnDragListener(this);
        piece4.setOnClickListener(this);
        piece4.setOnTouchListener(this);


        piece5.setOnDragListener(this);
        piece5.setOnClickListener(this);
        piece5.setOnTouchListener(this);


        piece6.setOnDragListener(this);
        piece6.setOnTouchListener(this);
        piece6.setOnClickListener(this);

        piece7.setOnDragListener(this);
        piece7.setOnTouchListener(this);
        piece7.setOnClickListener(this);

        piece8.setOnDragListener(this);
        piece8.setOnTouchListener(this);
        piece8.setOnClickListener(this);

        piece9.setOnDragListener(this);
        piece9.setOnTouchListener(this);
        piece9.setOnClickListener(this);

        setPosition(piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8, piece9);
    }

    /**
     * When the view is clicked, rotate the view for 90 degrees clockwise
     * @param v the view (in this case, ImageView)
     */
    @Override
    public void onClick(View v) {
        Animation rotate = new RotateAnimation(0.0f, 90.0f, v.getPivotX(), v.getPivotY());
        rotate.setDuration(1); // duration of the animation
        rotate.setRepeatCount(0);
        rotate.setRepeatMode(Animation.REVERSE);
        rotate.setFillAfter(true); // keep the rotated position after the animation

        // apply animation to the view
        v.setAnimation(rotate);
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        //if (event.getAction() == DragEvent.ACTION_DRAG_ENDED)
        //{
        float endX, endY;
        if (event.getAction() == DragEvent.ACTION_DRAG_LOCATION) {
            View dropped = (View) event.getLocalState();

            v.setX(event.getX());
            v.setY(event.getY());

            //View dropTarget = v;
            //dropped.setVisibility(View.INVISIBLE);
        } else if (event.getAction() == DragEvent.ACTION_DRAG_ENDED) {
            View dropped = (View) event.getLocalState();

            dropped.setX(event.getX());
            dropped.setY(event.getY());
        }
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);

            return true;
        }
        else return false;
        //return true;
    }

    public void setPosition(ImageView piece1, ImageView piece2, ImageView piece3, ImageView piece4,ImageView piece5,ImageView piece6,ImageView piece7,ImageView piece8,ImageView piece9) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int widthArea = displayMetrics.widthPixels;
        int heightArea = displayMetrics.heightPixels;
        //Init the random generator
        Random r = new Random();
        // Then for each Shape
        // ...
        RelativeLayout.LayoutParams pos1 =
                (RelativeLayout.LayoutParams)piece1.getLayoutParams();
        pos1.leftMargin =  r.nextInt(widthArea-100);
        pos1.topMargin =  r.nextInt(heightArea-100);
        piece1.setLayoutParams(pos1);

        RelativeLayout.LayoutParams pos2 =
                (RelativeLayout.LayoutParams)piece2.getLayoutParams();
        pos2.leftMargin =  r.nextInt(widthArea-100);
        pos2.topMargin =  r.nextInt(heightArea-100);
        piece2.setLayoutParams(pos2);

        RelativeLayout.LayoutParams pos3 =
                (RelativeLayout.LayoutParams)piece3.getLayoutParams();
        pos3.leftMargin =  r.nextInt(widthArea-100);
        pos3.topMargin =  r.nextInt(heightArea-100);
        piece3.setLayoutParams(pos3);

        RelativeLayout.LayoutParams pos4 =
                (RelativeLayout.LayoutParams)piece4.getLayoutParams();
        pos4.leftMargin =  r.nextInt(widthArea-100);
        pos4.topMargin =  r.nextInt(heightArea-100);
        piece4.setLayoutParams(pos4);

        RelativeLayout.LayoutParams pos5 =
                (RelativeLayout.LayoutParams)piece5.getLayoutParams();
        pos5.leftMargin =  r.nextInt(widthArea-100);
        pos5.topMargin =  r.nextInt(heightArea-100);
        piece5.setLayoutParams(pos5);

        RelativeLayout.LayoutParams pos6 =
                (RelativeLayout.LayoutParams)piece6.getLayoutParams();
        pos6.leftMargin =  r.nextInt(widthArea-100);
        pos6.topMargin=  r.nextInt(heightArea-100);
        piece6.setLayoutParams(pos6);

        RelativeLayout.LayoutParams pos7 =
                (RelativeLayout.LayoutParams)piece7.getLayoutParams();
        pos7.leftMargin =  r.nextInt(widthArea-100);
        pos7.rightMargin =  r.nextInt(heightArea-100);
        piece7.setLayoutParams(pos7);

        RelativeLayout.LayoutParams pos8 =
                (RelativeLayout.LayoutParams)piece8.getLayoutParams();
        pos8.leftMargin =  r.nextInt(widthArea-100);
        pos8.topMargin =  r.nextInt(heightArea-100);
        piece8.setLayoutParams(pos8);

        RelativeLayout.LayoutParams pos9 =
                (RelativeLayout.LayoutParams)piece9.getLayoutParams();
        pos9.leftMargin =  r.nextInt(widthArea-100);
        pos9.topMargin =  r.nextInt(heightArea-100);
        piece9.setLayoutParams(pos9);

    }
//
//        piece1.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) { RestoreButton(); }});
//        piece2.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) { RestoreButton(); }});
//        piece3.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) { RestoreButton(); }});
//        piece4.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) { RestoreButton(); }});
//        piece5.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) { RestoreButton(); }});
//        piece6.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) { RestoreButton(); }});
//        piece7.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) { RestoreButton(); }});
//        piece8.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) { RestoreButton(); }});
//        piece9.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) { RestoreButton(); }});
//
//
//
//    }
//
//
//    public boolean onTouchEvent (MotionEvent event){
//
//        float x = event.getX();
//        float y = event.getY();
//
//        try {
//            switch (event.getAction()) {
//                case MotionEvent.ACTION_DOWN:
//                    picMove(x, y);
//                    break;
//                case MotionEvent.ACTION_MOVE:
//                    picMove(x, y);
//                    break;
//                case MotionEvent.ACTION_UP:
//                    picMove(x, y);
//                    break;
//
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    private void picMove ( float x, float y){
//        mX = x - (intWidth / 2);
//        mY = y - (intHeight / 2) - 170;
//        if ((mX + intWidth) > ScreenX) {
//            mX = ScreenX - intWidth;
//        } else if (mX < 0) {
//            mX = 0;
//        } else if ((mY + intHeight - 170) > ScreenY) {
//            mY = ScreenY - intHeight;
//        } else if (mY < 0) {
//            mY = 0;
//        }
//        Log.i("jay", loat.toString(mX) + "," + Float.toString(mY));
//        mImageView01.setLayoutParams
//                (
//                        new AbsoluteLayout.LayoutParams
//                                (intWidth, intHeight, (int) mX, (int) mY));
//    }
//
//    public void RestoreButton () {
//
//    }


}
