package com.example.android.navigation.utils

import com.example.android.navigation.database.QuizzesData
import com.example.android.navigation.models.QuizData
import com.example.android.navigation.models.Status

fun convertArrayListToArray(arrayList: ArrayList<QuizData>): Array<QuizData?> {

    val array = arrayOfNulls<QuizData>(arrayList.size)

    for (i in 0 until arrayList.size)
        array[i] = arrayList.get(i)
    return array

}




 fun getStatuses(questions: ArrayList<QuizData>): ArrayList<Status> {
    val statuses = ArrayList<Status>()
    for (i: Int in 0 until questions.size) {
        statuses.add(questions[i].question_status)
    }
    return statuses
}


fun getDatas(quizzesDatas: List<QuizzesData>):ArrayList<QuizData> {

    var arrayList = ArrayList<QuizData>()

    for (i in 0 until quizzesDatas.size) {
        arrayList.add(QuizData(
                quizzesDatas[i].question_text,
                quizzesDatas[i].answer_1,
                quizzesDatas[i].answer_2,
                quizzesDatas[i].answer_3,
                quizzesDatas[i].answer_4,
                quizzesDatas[i].true_answer,
                Status.NOT_CHECKED,
                quizzesDatas[i].selection,
                quizzesDatas[i].score
        ))
    }
    return arrayList
}


fun getAndroidQuizList(): ArrayList<QuizData> {
    val quizData = ArrayList<QuizData>()
    quizData.add(
            QuizData("Is it possible to have an activity without UI to perform action/actions?",
                    "Not possible",
                    "Wrong Question",
                    "Yes it is possible",
                    "Non of the above",
                    "Yes it is possible",
                    Status.NOT_CHECKED, "",
                    3
            )
    )

    quizData.add(
            QuizData("What is android view group?",
                    "Collection of views and other child views",
                    "Layouts",
                    "Base class of building blocks",
                    "Non of the above",
                    "Collection of views and other child views",
                    Status.NOT_CHECKED, "",
                    5
            )
    )

    quizData.add(
            QuizData("What are the functionalities of Binder services in android?",
                    "Binder is responsible to manage the thread while using aidl in android",
                    "Binder is responsible for marshalling and un-marshalling of the data",
                    "A and B is correct",
                    "Binder is a kind of interface",
                    "A and B is correct",
                    Status.NOT_CHECKED, "",
                     8
            )
    )

    quizData.add(
            QuizData("How many applications are there in a particular given task in android?",
                    "Two",
                    "One",
                    "Many",
                    "Zero",
                    "Many",
                    Status.NOT_CHECKED, "",
                    4
            )
    )


    quizData.add(
            QuizData("What is the library of Map View in android?",
                    "com.map",
                    "com.goggle.gogglemaps",
                    "in.maps",
                    "com.goggle.android.maps",
                    "com.goggle.android.maps",
                    Status.NOT_CHECKED, "",
                    9
            )
    )

    quizData.add(
            QuizData("What are the JSON elements in android?",
                    "integer, boolean",
                    "null",
                    "boolean",
                    "Number, string, boolean, null, array, and object",
                    "Number, string, boolean, null, array, and object",
                    Status.NOT_CHECKED, "",
                    7

            )
    )


    quizData.add(
            QuizData("What is the purpose of super.onCreate() in android?",
                    "To create an activity",
                    "To create a graphical window for subclass",
                    "It allows the developers to write the program",
                    "No true answer",
                    "To create a graphical window for subclass",
                    Status.NOT_CHECKED, "",
                    5
            )
    )


    quizData.add(
            QuizData("Which company developed android?",
                    "Apple",
                    "Android.Inc",
                    "Nokia",
                    "Goggle",
                    "Android.Inc",
                    Status.NOT_CHECKED, "",
                    5
            )
    )

    quizData.add(
            QuizData("Which company bought android?",
                    "Apple",
                    "Android.in",
                    "Nokia",
                    "Goggle",
                    "Goggle",
                    Status.NOT_CHECKED, "",
                    3
            )
    )

    quizData.add(
            QuizData("Android is based on which kernel?",
                    "Linux kernel",
                    "Windows kernel",
                    "MAC kernel",
                    "Hybrid kernel",
                    "Linux kernel",
                    Status.NOT_CHECKED, "",
            9
            )
    )

    return quizData
}

fun getWebQuizList(): ArrayList<QuizData> {
    val quizData = ArrayList<QuizData>()
    quizData.add(
            QuizData("23m233dm14sm= ……… sm.",
                    "4643",
                    "4644",
                    "2300",
                    "1240",
                    "4644",
                    Status.NOT_CHECKED, "",
                    3
            )
    )

    quizData.add(
            QuizData("Natural son deb qanday sonlarga aytiladi",
                    "0 dan 9 gacha bo’lgan sonlarga aytiladi.",
                    "Sanashda ishlatiladigan sonlarga aytiladi",
                    "Barcha manfiy sonlarga aytiladi",
                    "Barcha musbat sonlarga aytiladi",
                    "Sanashda ishlatiladigan sonlarga aytiladi",
                    Status.NOT_CHECKED, "",
                    6
            )
    )

    quizData.add(
            QuizData("Yig'indini hisoblang.\n" +
                    "11 + 12 +13 + 14 + 15 + 16 + 17 + 18 + 19 + 20",
                    "155",
                    "165",
                    "105",
                    "175",
                    "155",
                    Status.NOT_CHECKED, "",
                    5
            )
    )

    quizData.add(
            QuizData("Harfli ifodaning qiymatini toping.\n" +
                    "(8a-2b)-(3a+4b) bunda   a=-2,1; b=4,5.",
                    "-25.5",
                    "-30.5",
                    "-21.5",
                    "-37.5",
                    "-37.5",
                    Status.NOT_CHECKED, "",
                    8
            )
    )


    quizData.add(
            QuizData("Tenglamani yeching. \n" +
                    "56x-47x=8961ː29ː3+59",
                    "18",
                    "21",
                    "9",
                    "16",
                    "18",
                    Status.NOT_CHECKED, ""
            ,5
            )
    )

    quizData.add(
            QuizData(". x+y+z=148 bo’lsa, \n" +
                    "(2x+y)+(2y+z)+(x+2z) yig’indini hisoblang!",
                    "440",
                    "405",
                    "444",
                    "144",
                    "444",
                    Status.NOT_CHECKED, "",
            6
            )
    )


    quizData.add(
            QuizData("Sonli ifodani qiymatini toping!\n" +
                    "356∙73+644∙27+27∙356+73∙64",
                    "56000",
                    "51200",
                    "57660",
                    "5079",
                    "57660",
                    Status.NOT_CHECKED, "",
            7
            )
    )


    quizData.add(
            QuizData("Tenglamani yeching:\n" +
                    " 0.36x-0.6 = (0.4x-1.2)∙3",
                    "1",
                    "25/7",
                    "9",
                    "1/7",
                    "25/7",
                    Status.NOT_CHECKED, "",
            8
            )
    )

    quizData.add(
            QuizData("119 ga bo'lganda, 31 hosil bo'lib, 29 qoldiq qoladigan sonni toping.",
                    "1890",
                    "3600",
                    "3760",
                    "3718",
                    "3718",
                    Status.NOT_CHECKED, "",
                    4


            )
    )

    quizData.add(
            QuizData("70 dan 100 gacha bo’lgan sonlar orasida nechta tub son mavjud ?",
                    "6",
                    "5",
                    "7",
                    "4",
                    "6",
                    Status.NOT_CHECKED, "",
                    9
            )
    )


    quizData.add(
            QuizData("80 ning natural bo’luvchilari nechta ?",
                    "9",
                    "12",
                    "6",
                    "10",
                    "9",
                    Status.NOT_CHECKED, "",
                    5
            )
    )


    quizData.add(
            QuizData(" 1 soat ning chorak qismi necha minut?",
                    "15",
                    "20",
                    "18",
                    "12",
                    "15",
                    Status.NOT_CHECKED, "",
                    5
            )
    )



    return quizData
}