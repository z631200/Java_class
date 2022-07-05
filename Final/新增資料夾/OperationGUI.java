import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class OperationGUI {
    private ArrayList <Member> memberlist = new ArrayList<Member>();
    private ArrayList <Book> booklist = new ArrayList<Book>();
    private Admin [] administrator = new Admin[3];
    private User usinguser;
    private ArrayList <JLabel> jlabellist = new ArrayList<>();

    private ArrayList <JCheckBox> jcheckboxlist = new ArrayList<>();
    private int findingtype;
    private String findingword;
    private boolean foundbook = false;
    

    public Scanner s = new Scanner(System.in);

    public void addMember(Member member){memberlist.add(member);}
    public void removeMember(Member member){memberlist.remove(member);}
    public void addBook(Book book){booklist.add(book);}
    public void removeBook(Book book){booklist.remove(book);}
    public String showBook(){
        String message = "";
        for(int i=0;i<booklist.size();i++){message += booklist.get(i) + "\n\n";}
        return message;
    }
    public void addAdmin(Admin admin){
        for(int i = 0;i<administrator.length;i++){
            if(administrator[i] == null){administrator[i] = admin;}
        }
    }
    public void setUsinguser(User usinguser){this.usinguser = usinguser;}
    public User getUsinguser(){return usinguser;}

    public void menu(){
        JFrame menu = new JFrame("圖書館借閱系統");
        menu.setSize(710, 400);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon menuicon = new ImageIcon("open-book.png");
        menu.setIconImage(menuicon.getImage());
        menu.setVisible(true);
        menu.setLayout(null);

        JButton loginbutton = new JButton("登入");
        loginbutton.setBounds(100, 70, 250, 250);
        loginbutton.setFont(new Font("Comic Sans", Font.BOLD, 80));
        loginbutton.setFocusable(false);
        loginbutton.setBackground(Color.CYAN);
        loginbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == loginbutton){
                    login();
                    menu.dispose();
                }
            }
        });

        JButton signupbutton = new JButton("註冊");
        signupbutton.setBounds(360, 70, 250, 250);
        signupbutton.setFont(new Font("Comic Sans", Font.BOLD, 80));
        signupbutton.setFocusable(false);
        signupbutton.setBackground(Color.orange);
        signupbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == signupbutton){
                    signup();
                    menu.dispose();
                }
            }
        });

        JLabel menulabel = new JLabel();
        menulabel.setText("歡迎來到圖書館借閱系統");
        menulabel.setBounds(100,30, 300, 30);
        menulabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        
        menu.add(signupbutton);
        menu.add(loginbutton);
        menu.add(menulabel);
    }
    public void signup(){
        JFrame signup = new JFrame("註冊");
        signup.setSize(710, 400);
        signup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon signupicon = new ImageIcon("add-user.png");
        signup.setIconImage(signupicon.getImage());
        signup.setVisible(true);
        signup.setLayout(null);

        JLabel identity = new JLabel();
        identity.setText("請選擇註冊身分");
        identity.setBounds(100,30, 300, 30);
        identity.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JCheckBox studentBox = new JCheckBox();
        studentBox.setBounds(100, 70, 20, 20);
        studentBox.setFont(new Font("Comic Sans", Font.BOLD, 25));
        studentBox.setFocusable(false);
        JLabel studentLabel = new JLabel("學生");
        studentLabel.setBounds(130, 70, 50, 20);
        studentLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JCheckBox staffBox = new JCheckBox();
        staffBox.setBounds(200, 70, 20, 20);
        staffBox.setFont(new Font("Comic Sans", Font.BOLD, 25));
        staffBox.setFocusable(false);
        JLabel staffLabel = new JLabel("職員工");
        staffLabel.setBounds(230, 70, 80, 20);
        staffLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JCheckBox teacherBox = new JCheckBox();
        teacherBox.setBounds(330, 70, 20, 20);
        teacherBox.setFont(new Font("Comic Sans", Font.BOLD, 25));
        teacherBox.setFocusable(false);
        JLabel tacherLabel = new JLabel("教師");
        tacherLabel.setBounds(360, 70, 50, 20);
        tacherLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        
        
        JLabel label = new JLabel();
        label.setText("請輸入姓名與帳號密碼(帳號密碼長度皆須大於4)");
        label.setBounds(100,100, 600, 30);
        label.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JLabel name = new JLabel("姓名:");
        name.setBounds(100,140,80,25);
        name.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JTextField nameText = new JTextField(20);
        nameText.setBounds(180,140,165,30);
        nameText.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JLabel account = new JLabel("帳號:");
        account.setBounds(100,180,80,25);
        account.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JTextField accountText = new JTextField(20);
        accountText.setBounds(180,180,165,30);
        accountText.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JLabel password = new JLabel("密碼:");
        password.setBounds(100,220,80,25);
        password.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JTextField passwordText = new JTextField(20);
        passwordText.setBounds(180,220,165,30);
        passwordText.setFont(new Font("Comic Sans", Font.BOLD, 20));

        JButton signupButton = new JButton("註冊");
        signupButton.setBounds(100, 270, 100, 35);
        signupButton.setBackground(Color.LIGHT_GRAY);
        signupButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        signupButton.setFocusable(false);
        signupButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == signupButton){
                    if((studentBox.isSelected() == true && staffBox.isSelected() == true) 
                    || (studentBox.isSelected() == true && teacherBox.isSelected() == true) 
                    || (staffBox.isSelected() == true && teacherBox.isSelected() == true)
                    || (studentBox.isSelected() == false && staffBox.isSelected() == false && teacherBox.isSelected() == false)){
                        JOptionPane.showMessageDialog(null, "請選擇一種身分", "錯誤", JOptionPane.ERROR_MESSAGE);
                        signup.dispose();
                        signup();
                    }
                    else{
                        int a1 = 0;
                        if(studentBox.isSelected() == true){a1 = 1;}
                        else if(staffBox.isSelected() == true){a1 = 2;}
                        else{a1 = 3;}
                        String name = nameText.getText();
                        String account = accountText.getText();
                        String password = passwordText.getText();
                        boolean isrepeated = false;
                        boolean isok = false;
                        for(int i = 0;i<memberlist.size();i++){
                            if(memberlist.get(i).getAccount() != null){
                                if(memberlist.get(i).getAccount().equals(account)){isrepeated = true;}
                            }
                        }
                        if(isrepeated == true){
                            JOptionPane.showMessageDialog(null, "帳號已被註冊，請重新輸入", "錯誤", JOptionPane.WARNING_MESSAGE);
                            signup.dispose();
                            signup();
                        }
                        else if((account.length() < 4) || (password.length() < 4)){
                            JOptionPane.showMessageDialog(null, "帳號密碼長度不足，請重新輸入", "錯誤", JOptionPane.WARNING_MESSAGE);
                            signup.dispose();
                            signup();
                        }
                        else {
                            ImageIcon okIcon = new ImageIcon("checked2.png");
                            JOptionPane.showMessageDialog(null, "註冊成功", "成功", JOptionPane.INFORMATION_MESSAGE, okIcon);
                            switch(a1){
                                case 1:
                                addMember(new Student(account, password, name));
                                break;
                                case 2:
                                addMember(new Staff(account, password, name));
                                break;
                                case 3:
                                addMember(new Teacher(account, password, name));
                                break;
                            }
                            isok = true;
                        }
                        if(isok == true){
                            signup.dispose();
                            login();
                        }
                    }
                }
            }
        });

        JButton backButton = new JButton("返回");
        backButton.setBounds(210, 270, 100, 35);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == backButton){
                    signup.dispose();
                    menu();
                }
            }
        });
        signup.add(label);
        signup.add(name);
        signup.add(nameText);
        signup.add(account);
        signup.add(accountText);
        signup.add(password);
        signup.add(passwordText);
        signup.add(signupButton);
        signup.add(identity);
        signup.add(studentBox);
        signup.add(studentLabel);
        signup.add(staffBox);
        signup.add(staffLabel);
        signup.add(teacherBox);
        signup.add(tacherLabel);
        signup.add(backButton);
    }
    public void login(){
        JFrame login = new JFrame("登入");
        login.setSize(710, 400);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon loginicon = new ImageIcon("login.png");
        login.setIconImage(loginicon.getImage());
        login.setVisible(true);
        login.setLayout(null);

        JLabel identity = new JLabel();
        identity.setText("請選擇登入身分");
        identity.setBounds(100,30, 300, 30);
        identity.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JCheckBox member = new JCheckBox();
        member.setBounds(100, 70, 20, 20);
        member.setFont(new Font("Comic Sans", Font.BOLD, 25));
        member.setFocusable(false);
        JLabel membertext = new JLabel("會員");
        membertext.setBounds(130, 70, 50, 20);
        membertext.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JCheckBox admin = new JCheckBox();
        admin.setBounds(200, 70, 20, 20);
        admin.setFont(new Font("Comic Sans", Font.BOLD, 25));
        admin.setFocusable(false);
        JLabel admintext = new JLabel("管理員");
        admintext.setBounds(230, 70, 80, 20);
        admintext.setFont(new Font("Comic Sans", Font.BOLD, 20));
        
        
        JLabel label = new JLabel();
        label.setText("請輸入帳號密碼");
        label.setBounds(100,100, 300, 30);
        label.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JLabel account = new JLabel("帳號:");
        account.setBounds(100,140,80,25);
        account.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JTextField accountText = new JTextField(20);
        accountText.setBounds(180,140,165,30);
        accountText.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JLabel password = new JLabel("密碼:");
        password.setBounds(100,180,80,25);
        password.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(180,180,165,30);
        passwordText.setFont(new Font("Comic Sans", Font.BOLD, 20));

        JButton loginButton = new JButton("登入");
        loginButton.setBounds(100, 230, 100, 35);
        loginButton.setBackground(Color.LIGHT_GRAY);
        loginButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == loginButton){
                    int a1 = 0;
                    if((member.isSelected() == true && admin.isSelected() == true) || (member.isSelected() == false && admin.isSelected() == false)){
                        JOptionPane.showMessageDialog(null, "請選擇一種身分", "錯誤", JOptionPane.ERROR_MESSAGE);
                        login.dispose();
                        login();
                    }
                    else{
                        if(member.isSelected() == true && admin.isSelected() == false){a1 = 1;}
                        else{a1 = 2;}

                        String account = accountText.getText();
                        String password = passwordText.getText();
                        boolean haveaccount = false;
                        boolean correct = false;
                        if(a1 == 1){
                            for(int i = 0;i<memberlist.size();i++){
                                if(memberlist.get(i) != null){
                                    if(memberlist.get(i).getAccount().equals(account)){
                                        haveaccount = true;
                                        if(memberlist.get(i).getPassword().equals(password)){
                                            correct = true;
                                            setUsinguser(memberlist.get(i));
                                        }
                                    }
                                }
                            }
                        }
                        else if(a1 == 2){
                            for(int i = 0;i<administrator.length;i++){
                                if(administrator[i] != null){
                                    if(administrator[i].getAccount().equals(account)){
                                        haveaccount = true;
                                        if(administrator[i].getPassword().equals(password)){
                                            correct = true;
                                            setUsinguser(administrator[i]);
                                        }
                                    }
                                }
                            }
                        }
                        if(haveaccount == false){
                            JOptionPane.showMessageDialog(null, "無此帳號，請重新登入", "錯誤", JOptionPane.ERROR_MESSAGE);
                            login.dispose();
                            login();
                        }
                        else if(haveaccount == true && correct == false){
                            JOptionPane.showMessageDialog(null, "密碼輸入錯誤，請重新輸入", "錯誤", JOptionPane.ERROR_MESSAGE);
                            login.dispose();
                            login();
                        }
                        else{
                            login.dispose();
                            intermenu();
                        }
                    }
                    
                }
            }
        });
        JButton backButton = new JButton("返回");
        backButton.setBounds(210, 230, 100, 35);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == backButton){
                    login.dispose();
                    menu();
                }
            }
        });

        login.add(label);
        login.add(account);
        login.add(accountText);
        login.add(password);
        login.add(passwordText);
        login.add(loginButton);
        login.add(identity);
        login.add(member);
        login.add(admin);
        login.add(membertext);
        login.add(admintext);
        login.add(backButton);
    }
    public void intermenu(){
        JFrame intermenu = new JFrame("圖書館借閱系統");
        intermenu.setSize(710, 400);
        intermenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon intermenuicon = new ImageIcon("open-book.png");
        intermenu.setIconImage(intermenuicon.getImage());
        intermenu.setVisible(true);
        intermenu.setLayout(null);

        JLabel label = new JLabel();
        label.setText("Hi~ " + usinguser.getName());
        label.setBounds(100,30, 300, 30);
        label.setFont(new Font("Comic Sans", Font.BOLD, 25));
        label.setVisible(true);

        JTextField findField = new JTextField();
        findField.setBounds(210,70,300,40);
        findField.setFont(new Font("Comic Sans", Font.BOLD, 22));
        findField.setText("請輸入檢索詞");

        String [] option = {"全部", "標題", "作者", "出版者", "主題"};
        JComboBox findComboBox = new JComboBox(option);
        findComboBox.setBounds(100, 70, 100, 40);
        findComboBox.setFont(new Font("Comic Sans", Font.BOLD, 22));

        JButton find = new JButton("搜尋");
        find.setBounds(520, 70, 80, 40);
        find.setFont(new Font("Comic Sans", Font.BOLD, 22));
        find.setFocusable(false);
        find.setVisible(true);

        find.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == find){
                        findingword = findField.getText();
                        intermenu.dispose();
                        showfindingbook();
                    }
                }});

        if(usinguser instanceof Member){
            JMenuBar userMenuBar = new JMenuBar(); //to store JMenuItem? 
            JMenu userMenu = new JMenu(usinguser.getName() + "  ");
            userMenu.setFont(new Font("Comic Sans", Font.BOLD, 17));
            userMenuBar.setBackground(Color.LIGHT_GRAY);
            JMenuItem recordItem = new JMenuItem("借閱紀錄");
            recordItem.setFont(new Font("Comic Sans", Font.BOLD, 13));
            JMenuItem changepassword = new JMenuItem("更改密碼");
            recordItem.setFont(new Font("Comic Sans", Font.BOLD, 13));
            JMenuItem logoutItem = new JMenuItem("登出");
            logoutItem.setFont(new Font("Comic Sans", Font.BOLD, 13));

            JPanel userPanel = new JPanel();
            userPanel.setBounds(620, 0, 80, 40);
            userPanel.setLayout(new BorderLayout());
            userPanel.add(userMenuBar, BorderLayout.NORTH);
            userMenuBar.add(userMenu);
            userMenu.add(recordItem);
            userMenu.add(changepassword);
            userMenu.add(logoutItem);

            logoutItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == logoutItem){
                        intermenu.dispose();
                        login();
                    }
                }});
                changepassword.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == changepassword){
                        intermenu.dispose();
                        changepassword();
                    }
                }});
            recordItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == recordItem){
                        intermenu.dispose();
                        showmemberbook();
                    }
                }});
            intermenu.add(userPanel);
        }
        else{
            JMenuBar userMenuBar = new JMenuBar();
            JMenu userMenu = new JMenu(usinguser.getName() + "  ");
            userMenu.setFont(new Font("Comic Sans", Font.BOLD, 17));
            userMenuBar.setBackground(Color.LIGHT_GRAY);
            JMenuItem listItem = new JMenuItem("書籍清單");
            listItem.setFont(new Font("Comic Sans", Font.BOLD, 13));
            JMenuItem addbookItem = new JMenuItem("新增書籍");
            addbookItem.setFont(new Font("Comic Sans", Font.BOLD, 13));
            JMenuItem logoutItem = new JMenuItem("登出");
            logoutItem.setFont(new Font("Comic Sans", Font.BOLD, 13));

            JPanel userPanel = new JPanel();
            userPanel.setBounds(620, 0, 80, 40);
            userPanel.setLayout(new BorderLayout());
            userPanel.add(userMenuBar, BorderLayout.NORTH);
            userMenuBar.add(userMenu);
            userMenu.add(listItem);
            userMenu.add(addbookItem);
            userMenu.add(logoutItem);

            listItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == listItem){
                        intermenu.dispose();
                        showadminbook();
                    }
                }});
            addbookItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == addbookItem){
                        intermenu.dispose();
                        addingbook();
                    }
                }});
            logoutItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == logoutItem){
                        intermenu.dispose();
                        login();
                    }
                }});

            intermenu.add(userPanel);
        }

        findingtype = 0;
        findComboBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == findComboBox){findingtype = findComboBox.getSelectedIndex();}
            }
        });
        
        
        intermenu.add(find);
        intermenu.add(findComboBox);
        intermenu.add(label);
        intermenu.add(findField);
        
        
    }
    public void addingbook(){
        JFrame addingbook = new JFrame("新增書籍");
        addingbook.setSize(710, 400);
        addingbook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon intermenuicon = new ImageIcon("open-book.png");
        addingbook.setIconImage(intermenuicon.getImage());
        addingbook.setVisible(true);
        addingbook.setLayout(null);

        JLabel input = new JLabel();
        input.setText("請輸入書籍資料");
        input.setBounds(100,30, 300, 30);
        input.setFont(new Font("Comic Sans", Font.BOLD, 25));

        JLabel titleLabel = new JLabel("書名:");
        titleLabel.setBounds(100,70,80,25);
        titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JLabel authorLabel = new JLabel("作者:");
        authorLabel.setBounds(100,110,80,25);
        authorLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JLabel publisherLabel = new JLabel("出版者:");
        publisherLabel.setBounds(100,150,130,25);
        publisherLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JLabel themeLabel = new JLabel("主題:");
        themeLabel.setBounds(100,190,80,25);
        themeLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));

        JTextField titleText = new JTextField(20);
        titleText.setBounds(215,70,165,30);
        titleText.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JTextField authorText = new JTextField(20);
        authorText.setBounds(215,110,165,30);
        authorText.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JTextField publisherText = new JTextField(20);
        publisherText.setBounds(215,150,165,30);
        publisherText.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JTextField themeText = new JTextField(20);
        themeText.setBounds(215,190,165,30);
        themeText.setFont(new Font("Comic Sans", Font.BOLD, 20));

        JButton addButton = new JButton("新增");
        addButton.setBounds(100, 240, 100, 35);
        addButton.setBackground(Color.LIGHT_GRAY);
        addButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        addButton.setFocusable(false);
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == addButton){
                    
                    String title = titleText.getText();
                    String author = authorText.getText();
                    String publisher =  publisherText.getText();
                    String theme = themeText.getText();
                    if(title.isEmpty() || author.isEmpty() ||  publisher.isEmpty() || theme.isEmpty()){
                        JOptionPane.showMessageDialog(null, "請輸入完整書籍資料", "錯誤", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                    addBook(new Book(title, author, publisher, theme));
                    ImageIcon okIcon = new ImageIcon("checked2.png");
                    JOptionPane.showMessageDialog(null, "新增成功", "成功", JOptionPane.INFORMATION_MESSAGE, okIcon);
                    addingbook.dispose();
                    addingbook();
                    }
                }
            }
        });

        JButton backButton = new JButton("返回");
        backButton.setBounds(210, 240, 100, 35);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == backButton){
                    addingbook.dispose();
                    intermenu();
                }
            }
        });

        addingbook.add(input);
        addingbook.add(titleLabel);
        addingbook.add(authorLabel);
        addingbook.add(publisherLabel);
        addingbook.add(themeLabel);
        addingbook.add(titleText);
        addingbook.add(authorText);
        addingbook.add(publisherText);
        addingbook.add(themeText);
        addingbook.add(addButton);
        addingbook.add(backButton);
    }
    public void showfindingbook(){
        JFrame showfindingbook = new JFrame("搜索結果");
        showfindingbook.setSize(2000, 400);
        showfindingbook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon intermenu = new ImageIcon("open-book.png");
        showfindingbook.setIconImage(intermenu.getImage());
        showfindingbook.setVisible(true);
        showfindingbook.setLayout(null);

        JButton backButton = new JButton("重新搜尋");
        backButton.setBounds(468,30, 118, 35);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        backButton.setFocusable(false);
        showfindingbook.add(backButton);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == backButton){
                    jlabellist.removeAll(jlabellist);
                    jcheckboxlist.removeAll(jcheckboxlist);
                    showfindingbook.dispose();
                    intermenu();
                }
            }
        });
        ArrayList <Book> findingbooks = new ArrayList<>();
        foundbook = false;
        for(int i = 0;i<booklist.size();i++){
        	switch(findingtype){
                case 0:
                if(booklist.get(i).getTitle().contains(findingword)){
                	findingbooks.add(booklist.get(i));
                	foundbook = true;
                }
                else if(booklist.get(i).getAuthor().contains(findingword)){
                	findingbooks.add(booklist.get(i));
                	foundbook = true;
                }
                else if(booklist.get(i).getPublisher().contains(findingword)){
                	findingbooks.add(booklist.get(i));
                	foundbook = true;
                }
                else if(booklist.get(i).getTheme().contains(findingword)){
                	findingbooks.add(booklist.get(i));
                	foundbook = true;
                }
                break;
                case 1:
                if(booklist.get(i).getTitle().contains(findingword)){
                	findingbooks.add(booklist.get(i));
                	foundbook = true;
                }
                break;
                case 2:
                if(booklist.get(i).getAuthor().contains(findingword)){
                	findingbooks.add(booklist.get(i));
                	foundbook = true;
                }
                break;
                case 3:
                if(booklist.get(i).getPublisher().contains(findingword)){
                	findingbooks.add(booklist.get(i));
                	foundbook = true;
                }
                break;
                case 4:
                if(booklist.get(i).getTheme().contains(findingword)){
                	findingbooks.add(booklist.get(i));
                	foundbook = true;
                }
                break;
            }
        }
        
        if(foundbook == true){
            JLabel label = new JLabel();
            label.setText("\"" + findingword + "\"搜索結果");
            label.setBounds(100,30, 385, 35);
            label.setFont(new Font("Comic Sans", Font.BOLD, 30));
            label.setVisible(true);
            showfindingbook.add(label);
            

            for(int i = 0;i < findingbooks.size();i++){
                String bookstate = "";
                if(findingbooks.get(i).getState() == true){bookstate = "狀態:已借出";}
                else{bookstate = "狀態:可借閱";}
                jlabellist.add(new JLabel(findingbooks.get(i).getTitle() + "            作者:" + findingbooks.get(i).getAuthor() + "      出版者:" + findingbooks.get(i).getPublisher() + "      主題:" + findingbooks.get(i).getTheme() + "      " + bookstate));
                jlabellist.get(i).setBounds(140, 70 + 25*i, 1550, 25);
                jlabellist.get(i).setFont(new Font("Comic Sans", Font.BOLD, 18));
                showfindingbook.add(jlabellist.get(i));

                jcheckboxlist.add(new JCheckBox());
                jcheckboxlist.get(i).setBounds(100, 70 + 25*i, 25, 25);
                jcheckboxlist.get(i).setFont(new Font("Comic Sans", Font.BOLD, 25));
                jcheckboxlist.get(i).setFocusable(false);
                showfindingbook.add(jcheckboxlist.get(i));
                
                
                    
                if(findingbooks.get(i).getState() == true){jcheckboxlist.get(i).setVisible(false);}
                
                
            }

        }
        else{
            JLabel label = new JLabel();
            label.setText("\"" + findingword + "\"搜索結果");
            label.setBounds(100,30, 300, 30);
            label.setFont(new Font("Comic Sans", Font.BOLD, 25));
            label.setVisible(true);
            showfindingbook.add(label);
            
            JLabel label1 = new JLabel();
            label1.setText("沒有匹配的結果");
            label1.setBounds(100,80, 300, 30);
            label1.setFont(new Font("Comic Sans", Font.BOLD, 25));
            label1.setVisible(true);
            showfindingbook.add(label1);
        }
        JButton borrowButton = new JButton();
        if(usinguser instanceof Member){borrowButton.setText("借閱");}
        else{borrowButton.setText("刪除");}
        borrowButton.setBounds(591,30, 80, 35);
        borrowButton.setBackground(Color.white);
        borrowButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        borrowButton.setFocusable(false);
        showfindingbook.add(borrowButton);
        borrowButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == borrowButton){
                    if(usinguser instanceof Member){
                        int checkcount = 0;
                        int membercount = 0;
                        for(int i = 0;i < jcheckboxlist.size();i++){
                            if(jcheckboxlist.get(i).isSelected() == true){
                                checkcount++;
                            }
                        }
                        if(checkcount == 0){JOptionPane.showMessageDialog(null, "請勾選書籍", "錯誤", JOptionPane.ERROR_MESSAGE);}
                        else{
                        if(usinguser instanceof Student){
                            Student usingstudent = (Student) usinguser;
                            for(int i = 0;i < 3;i++){
                                if(usingstudent.getBook(i) == null){
                                    membercount++;
                                }
                            }
                            
                            if(checkcount > membercount){JOptionPane.showMessageDialog(null, "選擇書籍數超越可借閱上限", "錯誤", JOptionPane.ERROR_MESSAGE);}
                            else {
                                    Date d = new Date();
                                    Date d1 = new Date(d.getTime() + (7*1000 * 60 * 60 * 24));
                                    
                                    for(int i = 0;i<jcheckboxlist.size();i++){
                                        if(jcheckboxlist.get(i) != null && findingbooks.get(i) != null)
                                    {
                                        if(jcheckboxlist.get(i).isSelected() == true){
                                            usingstudent.addBook(findingbooks.get(i));
                                            findingbooks.get(i).setState(true);
                                            findingbooks.get(i).setBorrowDate(d);
                                            findingbooks.get(i).setReturnDate(d1);
                                        }
                                    }
                                    }
                                    ImageIcon okIcon = new ImageIcon("checked2.png");
                                    JOptionPane.showMessageDialog(null, "借閱成功", "成功", JOptionPane.INFORMATION_MESSAGE, okIcon);
                                    jlabellist.removeAll(jlabellist);
                                    jcheckboxlist.removeAll(jcheckboxlist);
                                    showfindingbook.dispose();
                                    showfindingbook();
                                
                            }
                        }
                    
                        else if(usinguser instanceof Staff){
                            Staff usingstaff = (Staff) usinguser;
                            for(int i = 0;i < 4;i++){
                                if(usingstaff.getBook(i) == null){
                                    membercount++;
                                }
                            }
                            if(checkcount > membercount){JOptionPane.showMessageDialog(null, "選擇書籍數超越可借閱上限", "錯誤", JOptionPane.ERROR_MESSAGE);}
                            else {
                                    Date d = new Date();
                                    Date d1 = new Date(d.getTime() + (7*1000 * 60 * 60 * 24));
                                    for(int i = 0;i<jcheckboxlist.size();i++){
                                        if(jcheckboxlist.get(i) != null && findingbooks.get(i) != null)
                                    {
                                        if(jcheckboxlist.get(i).isSelected() == true){
                                            usingstaff.addBook(findingbooks.get(i));
                                            findingbooks.get(i).setState(true);
                                            findingbooks.get(i).setBorrowDate(d);
                                            findingbooks.get(i).setReturnDate(d1);
                                        }
                                    }
                                    }
                                    ImageIcon okIcon = new ImageIcon("checked2.png");
                                    JOptionPane.showMessageDialog(null, "借閱成功", "成功", JOptionPane.INFORMATION_MESSAGE, okIcon);
                                    jlabellist.removeAll(jlabellist);
                                    jcheckboxlist.removeAll(jcheckboxlist);
                                    showfindingbook.dispose();
                                    showfindingbook();
                                
                            }
                        }
                        else{
                            Teacher usingteacher = (Teacher) usinguser;
                            for(int i = 0;i < 5;i++){
                                if(usingteacher.getBook(i) == null){
                                    membercount++;
                                }
                            }
                            if(checkcount > membercount){JOptionPane.showMessageDialog(null, "選擇書籍數超越可借閱上限", "錯誤", JOptionPane.ERROR_MESSAGE);}
                            else {
                                    Date d = new Date();
                                    Date d1 = new Date(d.getTime() + (7*1000 * 60 * 60 * 24));
                                
                                    for(int i = 0;i<jcheckboxlist.size();i++){
                                        if(jcheckboxlist.get(i) != null && findingbooks.get(i) != null)
                                    {
                                        if(jcheckboxlist.get(i).isSelected() == true){
                                            usingteacher.addBook(findingbooks.get(i));
                                            findingbooks.get(i).setState(true);
                                            findingbooks.get(i).setBorrowDate(d);
                                            findingbooks.get(i).setReturnDate(d1);
                                        }
                                    }}
                                    ImageIcon okIcon = new ImageIcon("checked2.png");
                                    JOptionPane.showMessageDialog(null, "借閱成功", "成功", JOptionPane.INFORMATION_MESSAGE, okIcon);
                                    jlabellist.removeAll(jlabellist);
                                    jcheckboxlist.removeAll(jcheckboxlist);
                                    showfindingbook.dispose();
                                    showfindingbook();
                                
                            }
                        }}
                    }
                    else{
                    	int checkcount = 0;
                        for(int i = 0;i < jcheckboxlist.size();i++){
                            if(jcheckboxlist.get(i).isSelected() == true){
                                checkcount++;
                            }
                        }
                        if(checkcount == 0){JOptionPane.showMessageDialog(null, "請勾選書籍", "錯誤", JOptionPane.ERROR_MESSAGE);}
                        else{
                            int j = 0;    
                            for(int i = 0;i < jcheckboxlist.size();i++){
                                    if(jcheckboxlist.get(i).isSelected() == true){
                                        removeBook(booklist.get(j));
                                        j--;
                                    }
                                    j++;
                                }
                                ImageIcon okIcon = new ImageIcon("checked2.png");
                                JOptionPane.showMessageDialog(null, "刪除成功", "成功", JOptionPane.INFORMATION_MESSAGE, okIcon);
                                jlabellist.removeAll(jlabellist);
                                jcheckboxlist.removeAll(jcheckboxlist);
                                showfindingbook.dispose();
                                showfindingbook();
                        } 
                    }
                }
            }
    });

        
        
    }
    public void showadminbook(){
        JFrame showadminbook = new JFrame("書籍清單");
        showadminbook.setSize(2000, 1000);
        showadminbook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon intermenu = new ImageIcon("open-book.png");
        showadminbook.setIconImage(intermenu.getImage());
        showadminbook.setVisible(true);
        showadminbook.setLayout(null);

        JButton backButton = new JButton("返回");
        backButton.setBounds(468,30, 80, 35);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        backButton.setFocusable(false);
        showadminbook.add(backButton);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == backButton){
                    jlabellist.removeAll(jlabellist);
                    jcheckboxlist.removeAll(jcheckboxlist);
                    showadminbook.dispose();
                    intermenu();
                }
            }
        });

        for(int i = 0;i < booklist.size();i++){
            String bookstate = "";
            if(booklist.get(i).getState() == false){bookstate = "狀態:可借閱";}
            else{bookstate = "狀態:已借出";}
            jlabellist.add(new JLabel(booklist.get(i).getTitle() + "            作者:" + booklist.get(i).getAuthor() + "      出版者:" + booklist.get(i).getPublisher() + "      主題:" + booklist.get(i).getTheme() + "      " + bookstate));
            jlabellist.get(i).setBounds(140, 70 + 25*i, 1550, 25);
            jlabellist.get(i).setFont(new Font("Comic Sans", Font.BOLD, 18));
            showadminbook.add(jlabellist.get(i));

            jcheckboxlist.add(new JCheckBox());
            jcheckboxlist.get(i).setBounds(100, 70 + 25*i, 25, 25);
            jcheckboxlist.get(i).setFont(new Font("Comic Sans", Font.BOLD, 25));
            jcheckboxlist.get(i).setFocusable(false);
            showadminbook.add(jcheckboxlist.get(i));

            if(booklist.get(i).getState() == true){jcheckboxlist.get(i).setVisible(false);}
        }
        

        JLabel label = new JLabel();
        label.setText("書籍清單");
        label.setBounds(100,30, 385, 35);
        label.setFont(new Font("Comic Sans", Font.BOLD, 30));
        label.setVisible(true);
        showadminbook.add(label);

        JButton borrowButton = new JButton();
        borrowButton.setText("刪除");
        borrowButton.setBounds(553,30, 80, 35);
        borrowButton.setBackground(Color.white);
        borrowButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        borrowButton.setFocusable(false);
        showadminbook.add(borrowButton);
        borrowButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == borrowButton){
                        int checkcount = 0;
                        for(int i = 0;i < jcheckboxlist.size();i++){
                            if(jcheckboxlist.get(i).isSelected() == true){
                                checkcount++;
                            }
                        }
                        if(checkcount == 0){JOptionPane.showMessageDialog(null, "請勾選書籍", "錯誤", JOptionPane.ERROR_MESSAGE);}
                        else{
                            int j = 0;    
                            for(int i = 0;i < jcheckboxlist.size();i++){
                                    if(jcheckboxlist.get(i).isSelected() == true){
                                        removeBook(booklist.get(j));
                                        j--;
                                    }
                                    j++;
                                }
                                ImageIcon okIcon = new ImageIcon("checked2.png");
                                JOptionPane.showMessageDialog(null, "刪除成功", "成功", JOptionPane.INFORMATION_MESSAGE, okIcon);
                                jlabellist.removeAll(jlabellist);
                                jcheckboxlist.removeAll(jcheckboxlist);
                                showadminbook.dispose();
                                showadminbook();
                            
                        }
                }
            }
        });
    }
    public void showmemberbook(){
        JFrame showmemberbook = new JFrame("借閱紀錄");
        showmemberbook.setSize(2000, 400);
        showmemberbook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon intermenu = new ImageIcon("open-book.png");
        showmemberbook.setIconImage(intermenu.getImage());
        showmemberbook.setVisible(true);
        showmemberbook.setLayout(null);

        JButton backButton = new JButton("返回");
        backButton.setBounds(468,30, 80, 35);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        backButton.setFocusable(false);
        showmemberbook.add(backButton);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == backButton){
                    jlabellist.removeAll(jlabellist);
                    jcheckboxlist.removeAll(jcheckboxlist);
                    showmemberbook.dispose();
                    intermenu();
                }
            }
        });

        if(usinguser instanceof Student){
            Student usingstudent = (Student) usinguser;
            for(int i = 0;i < 3;i++){
                if(usingstudent.getBook(i) != null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String d = sdf.format(usingstudent.getBook(i).getBorrowDate());
                String d1 = sdf.format(usingstudent.getBook(i).getReturnDate());
                jlabellist.add(new JLabel(usingstudent.getBook(i).getTitle() + "      作者:" + usingstudent.getBook(i).getAuthor() + "      出版者:" + usingstudent.getBook(i).getPublisher() + "      主題:" + usingstudent.getBook(i).getTheme()+"      借閱日期" + d + "      應還日期:" + d1));
                jlabellist.get(i).setBounds(140, 70 + 50*i, 1550, 25);
                jlabellist.get(i).setFont(new Font("Comic Sans", Font.BOLD, 18));
                showmemberbook.add(jlabellist.get(i));
    
                jcheckboxlist.add(new JCheckBox());
                jcheckboxlist.get(i).setBounds(100, 70 + 50*i, 25, 25);
                jcheckboxlist.get(i).setFont(new Font("Comic Sans", Font.BOLD, 25));
                jcheckboxlist.get(i).setFocusable(false);
                showmemberbook.add(jcheckboxlist.get(i));
                }
            }
        }
        else if(usinguser instanceof Staff){
            Staff usingstaff = (Staff) usinguser;
            for(int i = 0;i < 4;i++){
                if(usingstaff.getBook(i) != null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String d = sdf.format(usingstaff.getBook(i).getBorrowDate());
                String d1 = sdf.format(usingstaff.getBook(i).getReturnDate());
                jlabellist.add(new JLabel(usingstaff.getBook(i).getTitle() + "      作者:" + usingstaff.getBook(i).getAuthor() + "      出版者:" + usingstaff.getBook(i).getPublisher() + "      主題:" + usingstaff.getBook(i).getTheme()+"      借閱日期:" + d + "      應還日期:" + d1));
                jlabellist.get(i).setBounds(140, 70 + 50*i, 1550, 25);
                jlabellist.get(i).setFont(new Font("Comic Sans", Font.BOLD, 18));
                showmemberbook.add(jlabellist.get(i));
    
                jcheckboxlist.add(new JCheckBox());
                jcheckboxlist.get(i).setBounds(100, 70 + 50*i, 25, 50);
                jcheckboxlist.get(i).setFont(new Font("Comic Sans", Font.BOLD, 25));
                jcheckboxlist.get(i).setFocusable(false);
                showmemberbook.add(jcheckboxlist.get(i));
                }
            }
        }
        else{
            Teacher usingteacher = (Teacher) usinguser;
            for(int i = 0;i < 5;i++){
                if(usingteacher.getBook(i) != null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String d = sdf.format(usingteacher.getBook(i).getBorrowDate());
                String d1 = sdf.format(usingteacher.getBook(i).getReturnDate());
                jlabellist.add(new JLabel(usingteacher.getBook(i).getTitle() + "      作者:" + usingteacher.getBook(i).getAuthor() + "      出版者:" + usingteacher.getBook(i).getPublisher() + "      主題:" + usingteacher.getBook(i).getTheme()+"      借閱日期:" + d + "      應還日期:" + d1));
                jlabellist.get(i).setBounds(140, 70 + 50*i, 1550, 25);
                jlabellist.get(i).setFont(new Font("Comic Sans", Font.BOLD, 18));
                showmemberbook.add(jlabellist.get(i));
    
                jcheckboxlist.add(new JCheckBox());
                jcheckboxlist.get(i).setBounds(100, 70 + 50*i, 25, 50);
                jcheckboxlist.get(i).setFont(new Font("Comic Sans", Font.BOLD, 25));
                jcheckboxlist.get(i).setFocusable(false);
                showmemberbook.add(jcheckboxlist.get(i));
                }
            }
        }

        

        JLabel label = new JLabel();
        label.setText("借閱紀錄");
        label.setBounds(100,30, 385, 35);
        label.setFont(new Font("Comic Sans", Font.BOLD, 30));
        label.setVisible(true);
        showmemberbook.add(label);

        JButton borrowButton = new JButton();
        borrowButton.setText("還書");
        borrowButton.setBounds(553,30, 80, 35);
        borrowButton.setBackground(Color.white);
        borrowButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        borrowButton.setFocusable(false);
        showmemberbook.add(borrowButton);
        borrowButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == borrowButton){
                        int checkcount = 0;
                        for(int i = 0;i < jcheckboxlist.size();i++){
                            if(jcheckboxlist.get(i).isSelected() == true){
                                checkcount++;
                            }
                        }
                        if(checkcount == 0 || checkcount > 1){JOptionPane.showMessageDialog(null, "請勾選一本書籍", "錯誤", JOptionPane.ERROR_MESSAGE);}
                        else{
                            for(int i = 0;i < jcheckboxlist.size();i++){
                                if(jcheckboxlist.get(i).isSelected() == true)
                                {
                                if(usinguser instanceof Student){
                                    Student usingstudent = (Student) usinguser;
                                    usingstudent.getBook(i).setState(false);

                                    Date d = usingstudent.getBook(i).getReturnDate();
                                    Date d1 = new Date();
                                    long diff = d.getTime() - d1.getTime();
                                    TimeUnit time = TimeUnit.DAYS; 
                                    long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
                                    if(diffrence < 0){JOptionPane.showMessageDialog(null, "逾期" + (-diffrence) + "天還書\n需繳交罰金" + (-diffrence) + "元", "錯誤", JOptionPane.WARNING_MESSAGE);}
                                    
                                    removeBook(usingstudent.getBook(i));
                                    addBook(usingstudent.getBook(i));
                                    usingstudent.removebook(i);
                                    for(int j = 0;j < 2-i;j++)
                                    {
                                    usingstudent.addBook(usingstudent.getBook(i+j+1));
                                    usingstudent.removebook(i+j+1);
                                    if(usingstudent.getBook(i+j+2) == null){break;}
                                    }
                                    
                                }
                                else if(usinguser instanceof Staff){
                                    Staff usingstaff = (Staff) usinguser;
                                    usingstaff.getBook(i).setState(false);

                                    Date d = usingstaff.getBook(i).getReturnDate();
                                    Date d1 = new Date();
                                    long diff = d.getTime() - d1.getTime();
                                    TimeUnit time = TimeUnit.DAYS; 
                                    long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
                                    if(diffrence < 0){JOptionPane.showMessageDialog(null, "逾期" + (-diffrence) + "天還書\n需繳交罰金" + (-diffrence) + "元", "錯誤", JOptionPane.WARNING_MESSAGE);}
                                    
                                    removeBook(usingstaff.getBook(i));
                                    addBook(usingstaff.getBook(i));
                                    usingstaff.removebook(i);
                                    for(int j = 0;j < 3-i;j++)
                                    {
                                    usingstaff.addBook(usingstaff.getBook(i+j+1));
                                    usingstaff.removebook(i+j+1);
                                    if(usingstaff.getBook(i+j+2) == null){break;}
                                    }
                                }
                                else{
                                    Teacher usingteacher = (Teacher) usinguser;
                                    usingteacher.getBook(i).setState(false);

                                    Date d = usingteacher.getBook(i).getReturnDate();
                                    Date d1 = new Date();
                                    long diff = d.getTime() - d1.getTime();
                                    TimeUnit time = TimeUnit.DAYS; 
                                    long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
                                    if(diffrence < 0){JOptionPane.showMessageDialog(null, "逾期" + (-diffrence) + "天還書\n需繳交罰金" + (-diffrence) + "元", "錯誤", JOptionPane.WARNING_MESSAGE);}
                                    
                                    removeBook(usingteacher.getBook(i));
                                    addBook(usingteacher.getBook(i));
                                    usingteacher.removebook(i);
                                    for(int j = 0;j < 4-i;j++)
                                    {
                                    usingteacher.addBook(usingteacher.getBook(i+j+1));
                                    usingteacher.removebook(i+j+1);
                                    if(usingteacher.getBook(i+j+2) == null){break;}
                                    }
                                }
                                }   
                            }
                        
                            ImageIcon okIcon = new ImageIcon("checked2.png");
                            JOptionPane.showMessageDialog(null, "還書成功", "成功", JOptionPane.INFORMATION_MESSAGE, okIcon);
                            jlabellist.removeAll(jlabellist);
                            jcheckboxlist.removeAll(jcheckboxlist);
                            showmemberbook.dispose();
                            showmemberbook();
                        }
                        
                }
            }
        });
    }
    public void changepassword(){
        JFrame changepassword = new JFrame("更改密碼");
        changepassword.setSize(710, 400);
        changepassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon signupicon = new ImageIcon("add-user.png");
        changepassword.setIconImage(signupicon.getImage());
        changepassword.setVisible(true);
        changepassword.setLayout(null);
        
        JLabel label = new JLabel();
        label.setText("請輸入舊密碼與新密碼(帳號密碼長度皆須大於4)");
        label.setBounds(100,30, 600, 30);
        label.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JLabel password1Label = new JLabel("舊密碼:");
        password1Label.setBounds(100,70,180,25);
        password1Label.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JPasswordField password1 = new JPasswordField(20);
        password1.setBounds(280,70,165,30);
        password1.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JLabel password2Label = new JLabel("新密碼:");
        password2Label.setBounds(100,110,180,25);
        password2Label.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JPasswordField password2 = new JPasswordField(20);
        password2.setBounds(280,110,165,30);
        password2.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JLabel password3Label = new JLabel("新密碼(確認):");
        password3Label.setBounds(100,150,180,25);
        password3Label.setFont(new Font("Comic Sans", Font.BOLD, 25));
        JPasswordField password3 = new JPasswordField(20);
        password3.setBounds(280,150,165,30);
        password3.setFont(new Font("Comic Sans", Font.BOLD, 20));

        JButton signupButton = new JButton("確認");
        signupButton.setBounds(100, 190, 100, 35);
        signupButton.setBackground(Color.LIGHT_GRAY);
        signupButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        signupButton.setFocusable(false);
        signupButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == signupButton){
                    
                        
                        String password11 = password1.getText();
                        String password22 = password2.getText();
                        String password33 = password3.getText();
                        boolean isok = false;
                        
                        if(usinguser.getPassword().equals(password11)){
                            if(password11.equals(password22)){JOptionPane.showMessageDialog(null, "新舊密碼相同，請重新輸入", "錯誤", JOptionPane.WARNING_MESSAGE);}
                            
                            else if(password33.equals(password22)){
                                if(password22.length() < 4){JOptionPane.showMessageDialog(null, "新密碼長度不足，請重新輸入", "錯誤", JOptionPane.WARNING_MESSAGE);}
                                else{
                                    ImageIcon okIcon = new ImageIcon("checked2.png");
                                    JOptionPane.showMessageDialog(null, "更改成功", "成功", JOptionPane.INFORMATION_MESSAGE, okIcon);
                                    isok = true;
                                    usinguser.setPassword(password22);
                                }
                            }
                            else{JOptionPane.showMessageDialog(null, "新密碼不相符，請重新輸入", "錯誤", JOptionPane.WARNING_MESSAGE);}
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "舊密碼輸入錯誤，請重新輸入", "錯誤", JOptionPane.WARNING_MESSAGE);
                            changepassword.dispose();
                            changepassword();
                        }
                        if(isok == true){
                            changepassword.dispose();
                            intermenu();
                        }
                        
                    
                }
            }
        });

        JButton backButton = new JButton("返回");
        backButton.setBounds(210, 190, 100, 35);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == backButton){
                    changepassword.dispose();
                    intermenu();
                }
            }
        });
        changepassword.add(label);
        changepassword.add(password1);
        changepassword.add(password2);
        changepassword.add(password3);
        changepassword.add(password1Label);
        changepassword.add(password2Label);
        changepassword.add(password3Label);
        changepassword.add(signupButton);
        changepassword.add(backButton);
    }   
}
