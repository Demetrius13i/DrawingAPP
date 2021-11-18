package com.dmitryi.example.drawingproject

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.dmitryi.example.drawingproject.MainActivity.Companion.brush
import com.dmitryi.example.drawingproject.MainActivity.Companion.path

class PaintView : View {

    var parametrs: ViewGroup.LayoutParams? = null

    companion object {
        var pathList = ArrayList<Path>()
        var colorList = ArrayList<Int>()
        var currentBrush = Color.BLACK
    }

    constructor(context: Context) : this(context, null) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {

        init()
    }

    private fun init() {
        brush.isAntiAlias = true
        brush.color = currentBrush
        brush.style = Paint.Style.STROKE
        brush.strokeJoin = Paint.Join.ROUND
        brush.strokeWidth = 12f

        parametrs = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var x = event?.x
        var y = event?.y

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                if (x != null) {
                    if (y != null) {
                        path.moveTo(x,y)
                    }
                }
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                if (x != null) {
                    if (y != null) {
                        path.lineTo(x,y)
                    }
                }
                pathList.add(path)
                colorList.add(currentBrush)
            }
            else -> return false
        }

        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas?) {

       for (i in pathList.indices){
           brush.setColor(colorList[i])
           canvas?.drawPath(pathList[i], brush)
           invalidate()
       }

    }
}