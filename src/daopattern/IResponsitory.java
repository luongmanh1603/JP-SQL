package daopattern;

import javafx.Student;

import java.util.ArrayList;

public interface IResponsitory <S>{
    ArrayList<S> getAll();
    Boolean create(S s);
    Boolean update(S s);
    Boolean delete(S s);
  //  Boolean edit(Student s);

    Student find(Integer id);
}
