package com.hriday.DrawingApp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        Bitmap bitmap = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_4444);
        imageView.setBackgroundDrawable(new BitmapDrawable(bitmap));
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        Paint t = new Paint();
        paint.setColor(Color.MAGENTA);
        t.setColor(Color.BLACK);
        t.setTextSize(50);

        canvas.drawText("Rectangle", 420, 150, t);
        canvas.drawRect(400, 200, 650, 700, paint);

        canvas.drawText("Circle", 120, 150, t);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(200, 350, 150, paint);

        canvas.drawText("Square", 120, 800, t);
        paint.setColor(Color.GREEN);
        canvas.drawRect(50, 850, 350, 1150, paint);

        canvas.drawText("Triangle", 480, 800, t);

        paint.setColor(Color.RED);
        drawTriangle(canvas, paint, 550, 1000, 300);
    }
    public void drawTriangle(Canvas canvas, Paint paint, int x, int y, int width) {
        int halfWidth = width / 2;

        Path path = new Path();
        path.moveTo(x, y - halfWidth); // Top
        path.lineTo(x - halfWidth, y + halfWidth); // Bottom left
        path.lineTo(x + halfWidth, y + halfWidth); // Bottom right
        path.lineTo(x, y - halfWidth); // Back to Top
        path.close();

        canvas.drawPath(path, paint);
    }
}