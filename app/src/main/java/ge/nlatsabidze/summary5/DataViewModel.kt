package ge.nlatsabidze.summary5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class DataViewModel : ViewModel() {

    private var _parsedJson = MutableLiveData<UserData>()
    val parsedJson: LiveData<UserData>
        get() = _parsedJson

    private var _mapOfItems = MutableLiveData<MutableMap<Int, String>>()
    val mapOfItems: LiveData<MutableMap<Int, String>>
        get() = _mapOfItems

    private val jsonObject =
        "[ \n" +
                "[ \n" +
                "{ \n" +
                "\"field_id\":1, \n" +
                "\"hint\":\"UserName\", \n" +
                "\"field_type\":\"input\", \n" +
                "\"keyboard\":\"text\", \n" +
                "\"required\":false, \n" +
                "\"is_active\":true, \n" +
                "\"icon\":\"https://jemala.png\" \n" +
                "}, \n" +
                "{ \n" +
                "\"field_id\":2, \n" +
                "\"hint\":\"Email\", \n" +
                "\"field_type\":\"input\", \n" +
                "\"required\":true, \n" +
                "\"keyboard\":\"text\", \n" +
                "\"is_active\":true, \n" +
                "\"icon\":\"https://jemala.png\" \n" +
                "}, \n" +
                "{ \n" +
                "\"field_id\":3, \n" +
                "\"hint\":\"phone\", \n" +
                "\"field_type\":\"input\", \n" +
                "\"required\":true, \n" +
                "\"keyboard\":\"number\", \n" +
                "\"is_active\":true, \n" +
                "\"icon\":\"https://jemala.png\" \n" +
                "} \n" +
                "], \n" +
                "[ \n" +
                "{ \n" +
                "\"field_id\":4,\n" +
                "\"hint\":\"FullName\", \n" +
                "\"field_type\":\"input\", \n" +
                "\"keyboard\":\"text\", \n" +
                "\"required\":true, \n" +
                "\"is_active\":true, \n" +
                "\"icon\":\"https://jemala.png\" }, \n" +
                "{ \n" +
                "\"field_id\":14, \n" +
                "\"hint\":\"Jemali\", \n" +
                "\"field_type\":\"input\", \n" +
                "\"keyboard\":\"text\", \n" +
                "\"required\":false, \n" +
                "\"is_active\":true, \n" +
                "\"icon\":\"https://jemala.png\" }, \n" +
                "{ \n" +
                "\"field_id\":89, \n" +
                "\"hint\":\"Birthday\", \n" +
                "\"field_type\":\"chooser\", \n" +
                "\"required\":false, \n" +
                "\"is_active\":true, \n" +
                "\"icon\":\"https://jemala.png\" }, \n" +
                "{ \n" +
                "\"field_id\":898, \n" +
                "\"hint\":\"Gender\", \n" +
                "\"field_type\":\"chooser\", \n" +
                "\"required\":\"false\", \n" +
                "\"is_active\":true, \n" +
                "\"icon\":\"https://jemala.png\" } \n" +
                "] \n" +
                "]\n"

    fun parseJson() {
        _parsedJson.value = Gson().fromJson(jsonObject, UserData::class.java)
    }
}