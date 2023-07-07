package com.sarvesh.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.math.log

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition :Int=0
    private var mUsername :String?=null
    private var mCorrectAnswers:Int=0

    private var progressbar:ProgressBar?=null
    private var tvProgress:TextView?=null
    private var tvQuestion:TextView?=null
    private var ivImage   :ImageView?=null

    private var tvOptionOne:TextView?=null
    private var tvOptionTwo:TextView?=null
    private var tvOptionThree:TextView?=null
    private var tvOptionFour:TextView?=null
    private var btnSubmit:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUsername=intent.getStringExtra(Constants.USER_NAME)

        progressbar=findViewById(R.id.progressbar)
        tvProgress=findViewById(R.id.tv_progress)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.iv_image)
        tvOptionOne=findViewById(R.id.tv_opt1)
        tvOptionTwo=findViewById(R.id.tv_opt2)
        tvOptionThree=findViewById(R.id.tv_opt3)
        tvOptionFour=findViewById(R.id.tv_opt4)
        btnSubmit=findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()

        setQuestion()
        defaultOptionView()

    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressbar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition"+"/"+"${progressbar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if(mCurrentPosition==mQuestionList!!.size){
            btnSubmit?.text="FINISH"
        }else{
            btnSubmit?.text="SUBMIT"
        }
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )

        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_opt1->{
                tvOptionOne?.let{
                    selectedOptionView(it,1)
                }
            }R.id.tv_opt2->{
                tvOptionTwo?.let{
                    selectedOptionView(it,2)
                }
            }R.id.tv_opt3->{
                tvOptionThree?.let{
                    selectedOptionView(it,3)
                }
            }R.id.tv_opt4->{
                tvOptionFour?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit->{
                if(mSelectedOptionPosition==0)
                {
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else->{
//                            Log.e("Current Position","$mCurrentPosition")
//                            Toast.makeText(this,"You made it to the end",Toast.LENGTH_SHORT).show()
                              val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUsername)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question=mQuestionList?.get(mCurrentPosition-1)
//                    Log.e("Correct answer","${question!!.}")
                    if(question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.incorrect_option_bg)
                    }else{mCorrectAnswers++}
                    answerView(question.correctAnswer,R.drawable.correct_option_bg)

                    if(mCurrentPosition==mQuestionList!!.size){
                        btnSubmit?.text="FINISH"
                    }
                    else
                    {
                        btnSubmit?.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer)
        {
            1->{tvOptionOne?.background=ContextCompat.getDrawable(
                this,
                drawableView
            )
            }
            2->{tvOptionTwo?.background=ContextCompat.getDrawable(
                this,
                drawableView
            )
            }
            3->{tvOptionThree?.background=ContextCompat.getDrawable(
                this,
                drawableView
            )
            }
            4->{tvOptionFour?.background=ContextCompat.getDrawable(
                this,
                drawableView
            )
            }

        }
    }
}