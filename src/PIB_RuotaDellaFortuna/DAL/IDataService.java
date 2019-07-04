package PIB_RuotaDellaFortuna.DAL;

import PIB_RuotaDellaFortuna.Domain.User;

import java.sql.SQLException;
import java.util.HashMap;

public interface IDataService {

    void saveNewUser(User ux) throws SQLException;
    HashMap<Integer,User> downloadUsersList() throws SQLException;

}
