package daopattern;

import javafx.Student;
import javafx.Subject;

import java.util.ArrayList;

public interface IResponsitory <S>{
    ArrayList<S> getAll();
    Boolean create(S s);

    Boolean update(S s);
    Boolean delete(S s);
  //  Boolean edit(Student s);

    S find(Integer id);
}
