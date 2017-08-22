package com.iconnic.worktemplate.views;
import com.iconnic.worktemplate.Vault;

/**
 * Created by Joseph "iconnic" Mpyana on 12/12/16.
 */
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

public class IconnicTextView extends TextView{
	
	public IconnicTextView(Context context){this(context, null);}
	
	public IconnicTextView(Context context, AttributeSet attrs){this(context, attrs, 0);}

    public IconnicTextView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr); setTypeface(Vault.iconnic);
    }
    
    @Override //a little gradient never hurt nobody
    protected void onLayout( boolean changed, 
        int left, int top, int right, int bottom )
    {
        super.onLayout( changed, left, top, right, bottom );
        if(changed)
        {
            //getPaint().setShader( new LinearGradient(0, 0, 0, getHeight(),Color.WHITE, Color.BLACK,Shader.TileMode.REPEAT ) );
        }
    }
}
