package net.glm.goal.Utility;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

/**
 * Created by Michael on 13/03/2018.
 */

public class BitmapUtility {


    public static Bitmap getResizebleCircleBitmap (Bitmap inputBitmap, int circleRadiusInPx) {

        float minimumSideSizeOfBitmap = (float) Math.min(inputBitmap.getHeight(), inputBitmap.getWidth());
        float multiplyCoefficient = ((circleRadiusInPx * 2) / minimumSideSizeOfBitmap);

        Bitmap resizedInputBitmap = Bitmap.createScaledBitmap(inputBitmap, (int) (inputBitmap.getWidth() * multiplyCoefficient),
                (int) (inputBitmap.getHeight() * multiplyCoefficient), true);

        Bitmap outputBitmap = Bitmap.createBitmap(circleRadiusInPx*2,
                circleRadiusInPx*2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(outputBitmap);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, circleRadiusInPx*2, circleRadiusInPx*2);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);

        canvas.drawCircle(circleRadiusInPx,circleRadiusInPx,circleRadiusInPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(resizedInputBitmap, rect, rect, paint);

        return outputBitmap;
    }



}
