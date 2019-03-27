# 实验三
## UI组件
### 创建自定义布局的AlertDialog
#### 点击clickme打开对话框
![无法显示](/images/1.png)
![无法显示](/images/2.png)
#### 输入预设的用户名密码
![无法显示](/images/3.png)
![无法显示](/images/4.png)
#### 输入错误的用户名密码
![无法显示](/images/5.png)
#### 关键代码
```
        Context context=MainActivity.this;
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        View v = View.inflate(MainActivity.this, R.layout.my_dialog, null);
        Button button=findViewById(R.id.clickme);
        final EditText tvUsername=(EditText)v.findViewById(R.id.tv_username);
        final EditText tvPassword=(EditText)v.findViewById(R.id.tv_password);
        builder.setView(v);
        builder.setCancelable(false);
        final AlertDialog alertDialog=builder.create();
        
        v.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                alertDialog.dismiss();
            }
        });
        v.findViewById(R.id.btn_sign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = tvUsername.getText().toString().trim();
                String psd = tvPassword.getText().toString().trim();
                if (uname.equals("lxy") && psd.equals("123456")) {
                    Toast.makeText(MainActivity.this, "登录成功", 0).show();
                    alertDialog.dismiss();// 对话框消失
                }
                else {
                    Toast.makeText(MainActivity.this, "登录失败", 0).show();
                    alertDialog.dismiss();// 对话框消失
                }
            }
        });
```
