package com.example.nfp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity2 extends AppCompatActivity {

    private EditText numOfEx;
    private EditText num;
    private EditText result;
    private TextView sum;
    private Button coun;
    private Button backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        numOfEx = findViewById(R.id.number_of_exercises);
        num = findViewById(R.id.number);
        result = findViewById(R.id.result);
        sum = findViewById(R.id.sum);
        coun = findViewById(R.id.count);
        backToMain = findViewById(R.id.back_to_main);

        coun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(numOfEx.getText().toString());
                int num2 = Integer.parseInt(num.getText().toString());
                double num3 = Double.parseDouble(result.getText().toString());

                for ( num1 = 0; num1 < 4; num1++) {


                    public class excel {
                        private final HashMap<Integer, Integer> ageCompare = new HashMap<>() {{
                            this.put(35, 0);
                            this.put(36, 1);
                        }};


                        String fileName = "D:/пробник/упражнения.xlsx";

                        File file = new File(fileName);


                        try {
                            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));

                            int sheetIndex = getSheetIndex(num1);

                            XSSFSheet sheet = workbook.getSheetAt(sheetIndex);

                            boolean exerciseInverse = isInverse(sheet, num2);

                            System.out.println(exerciseInverse);

                            for (int row = 1; row <= sheet.getLastRowNum(); row++) {
                                if (sheet.getRow(row).getCell(num2) == null) continue;

                                if (exerciseInverse) {
                                    if (sheet.getRow(row).getCell(num2).getNumericCellValue() >= num3) {

                                        num3 += sheet.getRow(row).getCell(0).getNumericCellValue();
                                        result.setText(Double.toString(num3));
                                        break;
                                    }
                                } else {
                                    if (sheet.getRow(row).getCell(num2).getNumericCellValue() <= num3) {

                                        num3 += sheet.getRow(row).getCell(0).getNumericCellValue();
                                        result.setText(Double.toString(num3));
                                        break;
                                    }
                                }
                            }
                        } catch (
                        IOException e)

                        {
                            e.printStackTrace();
                        }


                        private boolean isInverse(XSSFSheet sheet, int exercise) {
                            for (int row = 1; row <= sheet.getLastRowNum(); row++) {
                                if (sheet.getRow(row).getCell(exercise) == null) continue;

                                double lastValue = sheet.getRow(row).getCell(exercise).getNumericCellValue();

                                for (int toRow = row + 1; toRow <= sheet.getLastRowNum(); toRow++) {
                                    if (sheet.getRow(toRow).getCell(exercise) == null) continue;

                                    return lastValue < sheet.getRow(toRow).getCell(exercise).getNumericCellValue();
                                }
                            }

                            return false;
                        }


                        private int getSheetIndex(int age) {
                            for (int key : ageCompare.keySet()) {
                                if (age <= key) return ageCompare.get(key);
                            }


                            return -1;
                        }


                        public boolean isNotInt(String input) {
                            try {
                                Integer.parseInt(input);
                                return false;
                            } catch (NumberFormatException ex) {
                                return true;
                            }
                        }

                        public boolean isNotDouble(String input) {
                            try {
                                Double.parseDouble(input);
                                return false;
                            } catch (NumberFormatException ex) {
                                return true;
                            }
                        }
                    }

                }
            }
        });

        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = MainActivity2.this;
                Class nextActivity = MainActivity.class;
                Intent firstIntent = new Intent(context, nextActivity);
                startActivity(firstIntent);

            }

        });


    }
}

