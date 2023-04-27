package model;

import java.util.List;

public interface CRUD<T> {
    void add(T list);
    void display();
    void edit(String studentCode,T list);
    void delete(String studentCode);
}
