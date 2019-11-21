package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //Спринг может понимать по findBy - что нужно искать по username или указанному любому другому
    // для возврата одного пользователя
    //Optional<User> findByName(String name);

    // псевдо-скл с названиями класса и его свойств (т.е. используем не столбцы таблицы, а уже объекты). Это когда нам надо делать какие-нибудь кастомные запросы
    //@Query("SELECT u FROM User u WHERE u.username = 'admin'")
    //Iterable<User> findAllAdmins();

    // Нативный скл-запрос из-за опции nativeQuery = true
    //    @Query(value = "SELECT * FROM User u WHERE u.username = 'admin'", nativeQuery = true)
    //    Iterable<User> findAllAdmins();

}
