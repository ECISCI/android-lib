package com.mincat.test.testui.fra;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.mincat.sample.db.ben.Book;
import com.mincat.sample.db.ben.Person;
import com.mincat.sample.db.utils.XDbManager;
import com.mincat.sample.imagecache.more.CacheMoreImage;
import com.mincat.sample.imagecache.utils.DeleteAllImageCache;
import com.mincat.sample.manager.BaseFragment;
import com.mincat.sample.utils.L;
import com.mincat.sample.utils.T;
import com.mincat.test.R;
import com.mincat.test.testui.DbAndImageCache;
import com.mincat.test.testui.imagecache.CacheSingleImages;
import com.mincat.test.testui.volley.VolleyGet;
import com.mincat.test.testui.volley.VolleyPost;
import com.mincat.test.testui.xutils.XutilsGet;
import com.mincat.test.testui.xutils.XutilsPost;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * @author Ming
 */

public class MainHomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    View view;
    @BindView(R.id.rl_xutils_post)
    RelativeLayout rlXutilsPost;
    @BindView(R.id.rl_xutils_get)
    RelativeLayout rlXutilsGet;
    @BindView(R.id.rl_volley_get)
    RelativeLayout rlVolleyGet;
    @BindView(R.id.rl_volley_post)
    RelativeLayout rlVolleyPost;
    @BindView(R.id.rl_xutils_download)
    RelativeLayout rlXutilsDownload;
    @BindView(R.id.rl_xutils_upload)
    RelativeLayout rlXutilsUpload;
    @BindView(R.id.rl_db_add_person)
    RelativeLayout rlDbAddPerson;
    @BindView(R.id.rl_db_add_book)
    RelativeLayout rlDbAddBook;
    @BindView(R.id.rl_db_select_person)
    RelativeLayout rlDbSelectPerson;
    @BindView(R.id.rl_db_select_book)
    RelativeLayout rlDbSelectBook;
    @BindView(R.id.rl_db_delete_person)
    RelativeLayout rlDbDeletePerson;
    @BindView(R.id.rl_db_delete_book)
    RelativeLayout rlDbDeleteBook;
    Unbinder unbinder;
    @BindView(R.id.cache_single_image)
    RelativeLayout cacheSingleImage;
    @BindView(R.id.cache_list)
    RelativeLayout cacheList;
    @BindView(R.id.db_cache_image)
    RelativeLayout dbCacheImage;
    @BindView(R.id.delete_cache_single_image)
    RelativeLayout deleteCacheSingleImage;
    @BindView(R.id.delete_all)
    RelativeLayout deleteAll;


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fra_main, null);
        unbinder = ButterKnife.bind(this, view);

        initDataPerson();
        initDataBook();
        return view;
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.rl_xutils_post,
            R.id.rl_xutils_get,
            R.id.rl_volley_get,
            R.id.rl_volley_post,
            R.id.rl_xutils_download,
            R.id.rl_xutils_upload,
            R.id.rl_db_add_person,
            R.id.rl_db_add_book,
            R.id.rl_db_select_person,
            R.id.rl_db_select_book,
            R.id.rl_db_delete_person,
            R.id.rl_db_delete_book,
            R.id.cache_single_image,
            R.id.cache_list,
            R.id.db_cache_image,
            R.id.delete_cache_single_image,
            R.id.delete_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_xutils_post:
                intentUtils.openActivityFromRight(getActivity(), XutilsPost.class);
                break;
            case R.id.rl_xutils_get:
                intentUtils.openActivityFromRight(getActivity(), XutilsGet.class);
                break;
            case R.id.rl_volley_get:
                intentUtils.openActivityFromRight(getActivity(), VolleyGet.class);
                break;
            case R.id.rl_volley_post:
                intentUtils.openActivityFromRight(getActivity(), VolleyPost.class);
                break;
            case R.id.rl_xutils_download:
                T.showShort(getActivity(), "暂未测试");
                break;
            case R.id.rl_xutils_upload:
                T.showShort(getActivity(), "暂未测试");
                break;
            case R.id.rl_db_add_person:
                // 将集合<泛型为Person>数据插入到数据库中
                XDbManager.insertDb(persons);
                break;
            case R.id.rl_db_add_book:
                // 将集合<泛型为Book>数据插入到数据库中
                XDbManager.insertDb(books);
                break;
            case R.id.rl_db_select_person:

                // 查询Book表获取book表中的全部数据<返回类型为Peron泛型的集合>
                selectTablePerson();
                break;
            case R.id.rl_db_select_book:
                // 查询Book表获取book表中的全部数据<返回类型为Book泛型的集合>
                selectTableBook();
                break;
            case R.id.rl_db_delete_person:
                // 删除Person表
                XDbManager.deleteWhereTable(Person.class);
                break;
            case R.id.rl_db_delete_book:

                // 删除Book表
                XDbManager.deleteWhereTable(Book.class);
                break;
            case R.id.cache_single_image:
                intentUtils.openActivityFromRight(getActivity(), CacheSingleImages.class);
                break;
            case R.id.cache_list:
                intentUtils.openActivityFromRight(getActivity(), com.mincat.test.testui.imagecache.CacheMoreImage.class);
                break;

            // 进入缓存页面
            case R.id.db_cache_image:
                intentUtils.openActivityFromRight(getActivity(), DbAndImageCache.class);

                break;
            case R.id.delete_cache_single_image:
                break;
            // 删除全部缓存
            case R.id.delete_all:
                DeleteAllImageCache.delete(getActivity());
                XDbManager.deleteWhereTable(com.mincat.test.domain.Person.class);
                break;
        }
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

}
