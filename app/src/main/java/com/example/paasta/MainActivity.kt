package com.example.paasta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var recipeFragment: RecipeFragment
    private lateinit var reviewFragment: ReviewFragment
    private lateinit var cameraFragment: CameraFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var myPageFragment: MyPageFragment

    companion object {
        const val TAG: String = "로그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")


        bottom_nav.setOnNavigationItemSelectedListener(this)

        recipeFragment = RecipeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, recipeFragment).commit()

    }

    fun aaa(v : View){
        startActivity(Intent(this, Login::class.java))
    }

    fun bbb(v : View){
        startActivity(Intent(this, Profile::class.java))
    }

    fun ccc(v : View){
        startActivity(Intent(this, Recipe::class.java))
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "MainActivity - onNavigationItemSelected() called ")

        when(item.itemId){
            R.id.menu_recipe -> {
                Log.d(TAG, "MainActivity - 레시피 버튼 클릭")
                recipeFragment = RecipeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, recipeFragment).commit()
            }
            R.id.menu_review -> {
                Log.d(TAG, "MainActivity - 리뷰 버튼 클릭")
                reviewFragment = ReviewFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, reviewFragment).commit()
            }
            R.id.menu_camera -> {
                Log.d(TAG, "MainActivity - 카메라 버튼 클릭")
                cameraFragment = CameraFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, cameraFragment).commit()
            }
            R.id.menu_search -> {
                Log.d(TAG, "MainActivity - 서치 버튼 클릭")
                searchFragment = SearchFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, searchFragment).commit()
            }
            R.id.menu_profile -> {
                Log.d(TAG, "MainActivity - 마이페이지 버튼 클릭")
                myPageFragment = MyPageFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, myPageFragment).commit()
            }
        }

        return true
    }
}