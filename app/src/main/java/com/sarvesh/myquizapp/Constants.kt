package com.sarvesh.myquizapp

object Constants {

    const val USER_NAME :String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS: String="correct_answers"


    fun getQuestions():ArrayList<Question>{
        val questionList =ArrayList<Question>()
        //1
        val ques1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Argentina",
            "Japan",
            "China",
            "India",
            4
        )
        questionList.add(ques1)

        //2
        val ques2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Japan",
            "China",
            "India",
            1
        )
        questionList.add(ques2)

        //3
        val ques3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Japan",
            "Australia",
            "Nepal",
            3
        )
        questionList.add(ques3)

        //4
        val ques4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Japan",
            "Denmark",
            "Argentina",
            1
        )
        questionList.add(ques4)

        //5
        val ques5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Australia",
            "Afghanistan",
            "Brazil",
            "India",
            3
        )
        questionList.add(ques5)

        //6
        val ques6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Argentina",
            "Japan",
            "China",
            "Denmark",
            4
        )
        questionList.add(ques6)

        //7
        val ques7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Nepal",
            "Japan",
            "Fiji",
            "Belgium",
            3
        )
        questionList.add(ques7)

        //8
        val ques8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Armenia",
            "Germany",
            "China",
            "Uzbekistan",
            2
        )
        questionList.add(ques8)

        //9
        val ques9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Argentina",
            "Kuwait",
            "UAE",
            "Pakistan",
            2
        )
        questionList.add(ques9)

        //10
        val ques10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand",
            "Japan",
            "New York",
            "Fiji",
            1
        )
        questionList.add(ques10)


        return questionList
    }
}