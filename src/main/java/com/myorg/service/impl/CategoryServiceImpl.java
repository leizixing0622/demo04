package com.myorg.service.impl;

import com.myorg.dao.impl.CategoryDaoImpl;
import com.myorg.dao.impl.HotWordDaoImpl;
import com.myorg.dao.impl.HotWordLogoDaoImpl;
import com.myorg.dao.impl.HotWordTitleDaoImpl;
import com.myorg.model.Category;
import com.myorg.model.HotWord;
import com.myorg.model.HotWordLogo;
import com.myorg.model.HotWordTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl {

    @Autowired
    private CategoryDaoImpl categoryDao;

    @Autowired
    private HotWordTitleDaoImpl hotWordTitleDao;

    @Autowired
    private HotWordDaoImpl hotWordDao;

    @Autowired
    private HotWordLogoDaoImpl hotWordLogoDao;

    public List getCategoryList() {
        List<Category> categories = categoryDao.findAll();
        List list = new ArrayList();
        for(int i = 0; i < categories.size(); i ++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("hotWordCategory", categories.get(i));
            String hql = "from HotWordTitle a where a.categoryId = ?";
            Object[] params = {categories.get(i).getId()};
            List<HotWordTitle> hotWordTitles = hotWordTitleDao.findAllByHQL(hql, params);
            List list2 = new ArrayList();
            for(int j = 0; j < hotWordTitles.size(); j ++) {
                Map<String, Object> map1 = new HashMap<String, Object>();
                String hql2 = "from HotWord a where a.hotwordtitle_id = ?";
                Object[] params2 = {hotWordTitles.get(j).getId()};
                List<HotWord> hotWords = hotWordDao.findAllByHQL(hql2, params2);
                map1.put("hotWordTitle", hotWordTitles.get(j).getTitle());
                map1.put("hotWord", hotWords);
                list2.add(map1);
            }
            map.put("hotWordText", list2);
            String hql3 = "from HotWordLogo a where a.category_id = ?";
            Object[] params3 = {categories.get(i).getId()};
            List<HotWordLogo> hotWordLogos = hotWordLogoDao.findAllByHQL(hql3, params3);
            map.put("hotWordLogo", hotWordLogos);
            list.add(map);
        }
        return list;
    }
}
