package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var button0: Button
    private lateinit var buttonCong: Button
    private lateinit var buttonTru: Button
    private lateinit var buttonNhan: Button
    private lateinit var buttonChia: Button
    private lateinit var buttonDu: Button
    private lateinit var buttonDel: Button
    private lateinit var buttonAc: Button
    private lateinit var buttonBang: Button
    private lateinit var buttonPhay: Button
    private lateinit var input: EditText
    private lateinit var tvresult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các nút và EditText
        button1 = findViewById(R.id.bt_so1)
        button2 = findViewById(R.id.bt_so2)
        button3 = findViewById(R.id.bt_so3)
        button4 = findViewById(R.id.bt_so4)
        button5 = findViewById(R.id.bt_so5)
        button6 = findViewById(R.id.bt_so6)
        button7 = findViewById(R.id.bt_so7)
        button8 = findViewById(R.id.bt_so8)
        button9 = findViewById(R.id.bt_so9)
        button0 = findViewById(R.id.bt_so0)
        buttonCong = findViewById(R.id.bt_cong)
        buttonTru = findViewById(R.id.bt_tru)
        buttonNhan = findViewById(R.id.bt_nhan)
        buttonChia = findViewById(R.id.bt_chia)
        buttonDu = findViewById(R.id.bt_chiadu)
        buttonDel = findViewById(R.id.bt_del)
        buttonAc = findViewById(R.id.bt_ac)
        buttonBang = findViewById(R.id.bt_bang)
        buttonPhay = findViewById(R.id.bt_phay)
        input = findViewById(R.id.et_inputmath)
        tvresult = findViewById(R.id.tv_result)
        // Đặt sự kiện click cho các nút
        button1.setOnClickListener { appendNumber("1") }
        button2.setOnClickListener { appendNumber("2") }
        button3.setOnClickListener { appendNumber("3") }
        button4.setOnClickListener { appendNumber("4") }
        button5.setOnClickListener { appendNumber("5") }
        button6.setOnClickListener { appendNumber("6") }
        button7.setOnClickListener { appendNumber("7") }
        button8.setOnClickListener { appendNumber("8") }
        button9.setOnClickListener { appendNumber("9") }
        button0.setOnClickListener { appendNumber("0") }
        buttonCong.setOnClickListener { appendNumber("+") }
        buttonTru.setOnClickListener { appendNumber("-") }
        buttonNhan.setOnClickListener { appendNumber("x") }
        buttonChia.setOnClickListener { appendNumber("/") }
        buttonDu.setOnClickListener { appendNumber("%") }
        buttonDel.setOnClickListener { deleteNumber() }
        buttonAc.setOnClickListener { allClear()}
        buttonBang.setOnClickListener {
            val inputString = input.text.toString()
            val result = resultMath(inputString)
            tvresult.text = result
        }

        buttonPhay.setOnClickListener { appendNumber(",") }


    }
    private fun appendNumber(number: String) {
        val currentText = input.text.toString()
        val newText = currentText + number
        input.setText(newText)
    }
    private  fun allClear() {
        input.text.clear()
        tvresult.text = ""
    }
    private  fun deleteNumber() {
        if (input.text.isNotEmpty()) {
            // Xóa ký tự cuối cùng của EditText
            input.text.delete(input.text.length - 1, input.text.length)
        }

    }
    fun resultMath(expression: String): String {
        val stack = Stack<Double>()
        var currentNumber = 0.0
        var currentOperator = '+'

        for (i in 0 until expression.length) {
            val ch = expression[i]

            if (ch.isDigit() || ch == '.') {
                currentNumber = currentNumber * 10 + (ch - '0').toDouble()
            }

            if (!ch.isDigit() && ch != '.' || i == expression.length - 1) {
                when (currentOperator) {
                    '+' -> stack.push(currentNumber)
                    '-' -> stack.push(-currentNumber)
                    'x' -> stack.push(stack.pop() * currentNumber)
                    '/' -> stack.push(stack.pop() / currentNumber)
                    '%' -> stack.push(stack.pop() % currentNumber)
                }

                currentOperator = ch
                currentNumber = 0.0
            }
        }

        var result = 0.0
        while (!stack.isEmpty()) {
            result += stack.pop()
        }
        var check = (result - result.toInt()) * 10
        if (check == 0.0){
            val value: Int = result.toInt()
            return value.toString()
        }else{
            ;
        }

        return result.toString()
    }


}