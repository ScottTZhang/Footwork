/*
 * Copyright (C) The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.footwork;

//import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.google.android.gms.samples.vision.face.facetracker.ui.camera.GraphicOverlay;
import com.google.android.gms.vision.face.Face;

import java.util.Locale;

import static com.example.footwork.FaceTrackerActivity.drillList;
import static com.example.footwork.FaceTrackerActivity.randomDrill;

/**
 * Graphic instance for rendering face position, orientation, and landmarks within an associated
 * graphic overlay view.
 */
class FaceGraphic extends GraphicOverlay.Graphic {
    private static final float FACE_POSITION_RADIUS = 5.0f;
    private static final float ID_TEXT_SIZE = 250.0f; //default 40.0f
    private static final float ID_Y_OFFSET = 260.0f;  //default 50.0f
    private static final float ID_X_OFFSET = -260.0f; //default -50.0f
    private static final float BOX_STROKE_WIDTH = 5.0f;

    private static final int[] COLOR_CHOICES = {
            //       Color.BLUE,
            Color.CYAN,
            Color.GREEN,
            //       Color.MAGENTA,
            //       Color.RED,
            Color.WHITE,
            Color.YELLOW
    };

    private static int mCurrentColorIndex = 0;

    private final Paint mFacePositionPaint;
    private final Paint mIdPaint;
    private final Paint mBoxPaint;

    private volatile Face mFace;
    private int mFaceId;
    private String mFacePosition;
    //private float mFaceHappiness;

    FaceGraphic(GraphicOverlay overlay) {
        super(overlay);

        mCurrentColorIndex = (mCurrentColorIndex + 1) % COLOR_CHOICES.length;
        final int selectedColor = COLOR_CHOICES[mCurrentColorIndex];

        mFacePositionPaint = new Paint();
        mFacePositionPaint.setColor(selectedColor);

        mIdPaint = new Paint();
        mIdPaint.setColor(selectedColor);
        mIdPaint.setTextSize(ID_TEXT_SIZE);

        mBoxPaint = new Paint();
        mBoxPaint.setColor(selectedColor);
        mBoxPaint.setStyle(Paint.Style.STROKE);
        mBoxPaint.setStrokeWidth(BOX_STROKE_WIDTH);

    }

    void setId(int id) {
        mFaceId = id;
    }

    //set fixed position
    void setPosition(String position) {
        mFacePosition = position;
    }

    /**
     * Updates the face instance from the detection of the most recent frame.  Invalidates the
     * relevant portions of the overlay to trigger a redraw.
     */
    void updateFace(Face face) {
        mFace = face;
        postInvalidate();
    }

    /**
     * Draws the face annotations for position on the supplied canvas.
     */
    @Override
    public void draw(Canvas canvas) {
        Face face = mFace;
        if (face == null) {
            return;
        }

        // Draws a circle at the position of the detected face, with the face's track id below.
        float x = translateX(face.getPosition().x + face.getWidth() / 2);
        float y = translateY(face.getPosition().y + face.getHeight() / 2);
        canvas.drawCircle(x, y, FACE_POSITION_RADIUS, mFacePositionPaint);

        //canvas.drawText("id: " + mFaceId, x + ID_X_OFFSET, y + ID_Y_OFFSET, mIdPaint);
        //canvas.drawText("happiness: " + String.format(Locale.getDefault(), "%.2f", face.getIsSmilingProbability()), x - ID_X_OFFSET, y - ID_Y_OFFSET, mIdPaint);
        //canvas.drawText("right eye: " + String.format(Locale.getDefault(), "%.2f", face.getIsRightEyeOpenProbability()), x + ID_X_OFFSET * 2, y + ID_Y_OFFSET * 2, mIdPaint);
        //canvas.drawText("left eye: " + String.format(Locale.getDefault(), "%.2f", face.getIsLeftEyeOpenProbability()), x - ID_X_OFFSET * 2, y - ID_Y_OFFSET * 2, mIdPaint);
        //canvas.drawText("width: " + String.format(Locale.getDefault(), "%.2f", face.getWidth()), x - ID_X_OFFSET * 2, y - ID_Y_OFFSET * 2, mIdPaint);
        //canvas.drawText("height: " + String.format(Locale.getDefault(), "%.2f", face.getHeight()), x + ID_X_OFFSET * 2, y + ID_Y_OFFSET * 2, mIdPaint);

        String directionText = "";
        String heightText = "";
        switch (mFacePosition) {
            case "lbh":
                //imageView.setImageResource(R.drawable.lbh);
                directionText = "↙";
                heightText = "HIGH";
                break;
            case "lbl":
                //imageView.setImageResource(R.drawable.lbl);
                directionText = "↙";
                heightText = "LOW";
                break;
            case "lfh":
                //imageView.setImageResource(R.drawable.lfh);
                directionText = "↖";
                heightText = "HIGH";
                break;
            case "lfl":
                //imageView.setImageResource(R.drawable.lfl);
                directionText = "↖";
                heightText = "LOW";
                break;
            case "lml":
                //imageView.setImageResource(R.drawable.lml);
                directionText = "←";
                heightText = "LOW";
                break;
            case "lmh":
                //imageView.setImageResource(R.drawable.lmh);
                directionText = "←";
                heightText = "HIGH";
                break;
            case "rfl":
                //imageView.setImageResource(R.drawable.rfl);
                directionText = "↗";
                heightText = "LOW";
                break;
            case "rfh":
                //imageView.setImageResource(R.drawable.rfh);
                directionText = "↗";
                heightText = "HIGH";
                break;
            case "rml":
                //imageView.setImageResource(R.drawable.rml);
                directionText = "→";
                heightText = "LOW";
                break;
            case "rmh":
                //imageView.setImageResource(R.drawable.rmh);
                directionText = "→";
                heightText = "HIGH";
                break;
            case "rbl":
                //imageView.setImageResource(R.drawable.rbl);
                directionText = "↘";
                heightText = "LOW";
                break;
            case "rbh":
                //imageView.setImageResource(R.drawable.rbh);
                directionText = "↘";
                heightText = "HIGH";
                break;
        }
        //canvas.drawText(text, x + ID_X_OFFSET * 7, y + ID_Y_OFFSET * 7, mIdPaint);
        canvas.drawText(directionText, x + ID_X_OFFSET / 2, y - ID_Y_OFFSET, mIdPaint);
        canvas.drawText(heightText, x + ID_X_OFFSET, y + ID_Y_OFFSET, mIdPaint);
        //double height = face.getHeight();
    }
}
