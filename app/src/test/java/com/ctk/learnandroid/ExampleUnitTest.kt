package com.ctk.learnandroid

import android.provider.ContactsContract
import com.blankj.utilcode.util.RegexUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Response
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val gson = Gson()

    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)

//        println(RegexUtils.isUsername("YYY"))

        val rawData: Response<Data> = Response(Data("数据"), 1, "成功")
        println(rawData.toString())
        val toJson = Gson().toJson(rawData)
        println(toJson)

        val response: Response<Data>
        val type = object : TypeToken<Response<Data>>() {}.type
        println(type)

        response = gson.fromJson(toJson, type)
        println(response)
        val response2: Response<Data>
        val type2 = object : TypeReference<Response<Data>>() {}.getType()
        response2 = gson.fromJson(toJson, type2)
        println(response2)
    }

    class Response<T>(var data: T, var code: Int, var message: String) {
        override fun toString(): String {
            return "Response{" +
                    "data=" + data +
                    ", code=" + code +
                    ", message='" + message + '\'' +
                    '}'
        }
    }

    class Data(var result: String) {
        override fun toString(): String {
            return "Data{" +
                    "result=" + result +
                    '}'
        }
    }

    open class TypeReference<T> protected constructor() {


        private var type: Type

        init {
            val genericSuperclass = javaClass.genericSuperclass
            val parameterizedType = genericSuperclass as ParameterizedType
            val actualTypeArguments = parameterizedType.actualTypeArguments
            type = actualTypeArguments[0]
        }

        fun getType(): Type {
            return type
        }


    }
}


