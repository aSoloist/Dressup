package system.dressup.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by idea on 2018/3/19.
 * @author Soloist
 */

public class CircularImageView extends AppCompatImageView {

    private Paint circularPaint;

    private int circularRadius;

    private float circularScala;

    public CircularImageView(Context context) {
        super(context);
    }

    public CircularImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Bitmap drawable2Bitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            return bitmapDrawable.getBitmap();
        }

        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        circularPaint = new Paint();

        Bitmap bitmap = drawable2Bitmap(getDrawable());
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        circularScala = (circularRadius * 2.0f) / Math.min(bitmap.getHeight(), bitmap.getHeight());
        Matrix matrix = new Matrix();
        matrix.setScale(circularScala, circularScala);
        bitmapShader.setLocalMatrix(matrix);

        circularPaint.setShader(bitmapShader);

        canvas.drawCircle(circularRadius, circularRadius, circularRadius, circularPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int size = Math.min(getMeasuredWidth(), getMeasuredHeight());
        circularRadius = size / 2;

        setMeasuredDimension(size, size);
    }
}
