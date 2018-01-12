package com.mincat.test.testui.db;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.mincat.sample.db.ben.Book;
import com.mincat.sample.db.ben.Person;
import com.mincat.sample.db.utils.XDbManager;
import com.mincat.sample.manager.base.AppCompat;
import com.mincat.sample.utils.L;
import com.mincat.test.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ming
 * @描述 操作数据库
 */

public class Database extends AppCompat {

    /**
     * 操作Person表
     *
     * @说明 Person类在Mincat类库中
     */
    private Person person;
    private List<Person> persons;
    private List<Person> select_person;

    /**
     * 操作Book表
     *
     * @说明 Book类在Mincat类库中
     */
    private List<Book> books;
    private List<Book> select_book;
    private Book book;

    private Button add_person, add_book, selectFromBook, selectFromPerson, delete_person, delete_book;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_db);
        initView();

    }

    /**
     * 初始化相关参数
     */
    @Override
    public void initView() {
        initToolBar(R.id.toolbar);

        initDataPerson();
        initDataBook();

        add_person = getId(R.id.add_person);
        add_person.setOnClickListener(this);

        add_book = getId(R.id.add_book);
        add_book.setOnClickListener(this);

        selectFromBook = getId(R.id.select_book);
        selectFromBook.setOnClickListener(this);

        selectFromPerson = getId(R.id.select_person);
        selectFromPerson.setOnClickListener(this);

        delete_person = getId(R.id.delete_person);
        delete_person.setOnClickListener(this);

        delete_book = getId(R.id.delete_book);
        delete_book.setOnClickListener(this);
    }

    /**
     * 初始化书籍数据
     */
    private void initDataBook() {

        book = new Book();
        book.date = new Date();
        book.name = "三国演义";
        book.price = 17.8f;

        books = new ArrayList<>();
        books.add(book);


    }


    /**
     * 初始化数据 将数据保存到集合中再插入数据库 这是规则
     */
    private void initDataPerson() {
        person = new Person();
        person.name = "张三";
        person.age = 15;
        person.sex = "男";

        persons = new ArrayList<>();
        persons.add(person);


    }

    /**
     * 查询Person表
     */
    private void selectTablePerson() {

        select_person = new ArrayList<>();

        List<Person> person = (List<Person>) XDbManager.selectFromWhereTable(Person.class, select_person);

        L.i(TAG, "从Person表中查出的数据是:" + person);

    }

    /**
     * 查询Book表
     */
    private void selectTableBook() {

        select_book = new ArrayList<>();

        List<Book> book = (List<Book>) XDbManager.selectFromWhereTable(Book.class, select_book);

        L.i(TAG, "从book表中查出的数据是:" + book);

    }

    @Override
    public void onNetRequest() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.add_person:
                // 将集合<泛型为Person>数据插入到数据库中
                XDbManager.insertDb(persons);
                break;
            case R.id.add_book:
                // 将集合<泛型为Book>数据插入到数据库中
                XDbManager.insertDb(books);
                break;

            case R.id.select_book:
                // 查询Book表获取book表中的全部数据<返回类型为Book泛型的集合>
                selectTableBook();
                break;
            case R.id.select_person:

                // 查询Book表获取book表中的全部数据<返回类型为Peron泛型的集合>
                selectTablePerson();

                break;
            case R.id.delete_book:
                // 删除Book表
                XDbManager.deleteWhereTable(Book.class);

                break;
            case R.id.delete_person:
                // 删除Person表
                XDbManager.deleteWhereTable(Person.class);
                break;
        }

    }
}
