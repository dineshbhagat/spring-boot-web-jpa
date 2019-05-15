package com.example.jpa;

import com.example.entity.Article;
import com.example.entity.Comment;
import com.example.entity.Tag;
import com.example.entity.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAEntityLevelTests {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    NodetypesRepository nodetypesRepository;

    @Autowired
    NodesRepository nodesRepository;
    
    @Test
    public void testHibernate() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            List<User> users = entityManager.createNativeQuery(
                    "select p.* " +
                            "from User p",
                    User.class)
                    .getResultList();
            users.forEach(System.out::println);
            System.out.println("Comment Result------------------");
            Comment com = entityManager.find(Comment.class, 1L);
            System.out.println(com);
            List<Comment> comments = entityManager.createNativeQuery("SELECT a.* FROM Comment a", Comment.class)
                    .getResultList();
            comments.forEach(System.out::println);
            System.out.println("Article Result------------------");
            List<Article> articles = entityManager.createNativeQuery("SELECT a.* FROM Article a", Article.class)
                    .getResultList();
            articles.forEach(System.out::println);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        } finally {
        }
    }

    @Test
    public void addManyToManyEntityTest() {
        Tag javaTag = new Tag();
        javaTag.setName("java");
        javaTag.setDescription("Java related tag");

        Tag hibernateTag = new Tag();
        hibernateTag.setName("hibernate");
        hibernateTag.setDescription("Hibernate related tag");

        Set<Tag> tagSet = Sets.newSet(javaTag, hibernateTag);

        Article article1 = new Article();
        article1.setArticleText("This is my article with tag");
        article1.setTags(tagSet);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(article1);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }

        List<Article> article = entityManager.createQuery("From Article").getResultList();
        article.forEach(System.out::println);
    }
    
        //@Test
    public void testCreateNodetype() {
        Nodetypes nodetypes = new Nodetypes();
        nodetypes.setId(1);
        nodetypes.setLabel("myLabel");
        nodetypes.setName("44");
        nodetypes.setIs_group(true);
        nodetypes.setCreated_at(new java.util.Date());

        nodetypesRepository.save(nodetypes);
    }

    @Test
    public void testCreateNodes() {
        testCreateNodetype();
        Nodetypes nodetype = nodetypesRepository.findById(1).get();
        Nodes node1 = new Nodes();
        node1.setCreated_at(new java.util.Date());
        node1.setName("nodeName");
        node1.setNode_id(444);
        node1.setNodetypes(nodetype);

        nodesRepository.save(node1);
    }
}
