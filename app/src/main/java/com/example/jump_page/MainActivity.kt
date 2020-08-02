package com.example.jump_page

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//       关联页面
        setContentView(R.layout.activity_main)

//  获取用户点击事件
//        按键的监听事件:方法一（思路：loginButton检查到监听事件，实现监听方法，向方法传入监听点击事件的对象
//        对象实现监听接口，实现监听方法，然后去调用监听方法）
//        loginButton.setOnClickListener(this)

//        方法二 ：匿名对象
//        loginButton.setOnClickListener(object :View.OnClickListener{
//            override fun onClick(v: View?) {
//                println("被点击了")
//            }
//        })

//        方法三：lambda表达式
//        loginButton.setOnClickListener{view:View? ->
//            println("你好啊")
//        }
//        最终版本，
        loginButton.setOnClickListener{
            println("你好啊")

////            添加动画  java的方法
            /*
//            val anim = ObjectAnimator.ofFloat(ykimageView,"rotation",0f,360f)
//            anim.duration = 100
//            anim.repeatCount = 6
//            anim.start()
////            监听动画结束事件
//            anim.addListener(object : Animator.AnimatorListener{
//                override fun onAnimationRepeat(animation: Animator?) {}
//                override fun onAnimationEnd(animation: Animator?) {
//                    //            跳转界面
//                    startActivity(Intent(this@MainActivity,Main2Activity::class.java))
//                    }
//                override fun onAnimationCancel(animation: Animator?) {}
//                override fun onAnimationStart(animation: Animator?) {}
//            })
*/
//            添加动画， kotlin写法

//            also关键字
            /*
            ObjectAnimator.ofFloat(ykimageView,"rotation",0f,360f).also {
                it.duration = 100
                it.repeatCount = 6
                it.start()
                it.addListener(object : Animator.AnimatorListener{
                    override fun onAnimationRepeat(animation: Animator?) {}
                    override fun onAnimationEnd(animation: Animator?) {
                        //            跳转界面
                        startActivity(Intent(this@MainActivity,Main2Activity::class.java))
                    }
                    override fun onAnimationCancel(animation: Animator?) {}
                    override fun onAnimationStart(animation: Animator?) {}
                })
            }
            */

//            apply关键字
            ObjectAnimator.ofFloat(ykimageView,"rotation",0f,360f).apply {
                duration = 100
                repeatCount = 6
                start()
//                调用自己写的监听类
                addListener(object : ykAnimationListener(){
                    override fun onAnimationEnd(animation: Animator?) {
                        startActivity(Intent(this@MainActivity,Main2Activity::class.java))
                    }
                })
            }
        }
    }

    override fun onClick(v: View?) {

    }
}
