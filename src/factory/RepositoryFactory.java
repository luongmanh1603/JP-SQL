package factory;

import daopattern.IResponsitory;
import daopattern.StudentResponsitory;
import daopattern.SubjectRepository;
import enums.RepositoryType;

public class RepositoryFactory {
    public  static IResponsitory createRepositoryInstance(RepositoryType type){
        if (type == RepositoryType.SUBJECT)
            return SubjectRepository.getInstance();
        else if (type == RepositoryType.STUDENT)
            return StudentResponsitory.getInstance();
        return null;
    }
}
