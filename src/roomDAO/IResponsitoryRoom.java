package roomDAO;

import Classroom.Room;

import java.util.ArrayList;

public interface IResponsitoryRoom <R> {
    ArrayList<R> getAll();

    Boolean create(Room r);

    Boolean update(Room r);

    Boolean delete(Room r);
    Room find(Integer id);
}
