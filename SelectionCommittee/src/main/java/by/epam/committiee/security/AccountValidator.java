package by.epam.committiee.security;

import by.epam.committiee.dao.impl.AccountDao;
import by.epam.committiee.entity.Account;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.exception.HasherException;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.exception.ValidatorException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountValidator {
//    private static final Logger LOGGER = LogManager.getLogger();

    public boolean validate(String login,String password) {
        AccountDao dao = AccountDao.getInstance();

        try {
            if (login == null || login.isEmpty()) {
                throw new ValidatorException("invalid login");
            }
            if (password == null || password.isEmpty()) {
                throw new ValidatorException("invalid password");
            }
            Account account = dao.findBy(login);
            if (account.getLogin() != null && !account.getLogin().isEmpty()) {
           //     LOGGER.debug("account found");
                Hasher hasher = new Hasher();
                byte[] hash = hasher.hash(password, account.getSalt());

                if (//account.getLogin().equals(login) && account.getPassword().equals(password)){
                 compareHashes(account.getHash(), hash)) {
              //      account.setPassword(null);
              //      account.setHash(new byte[] {});
               //     logger.info("account is valid");
                    return true;
                }
            }

        } catch (DaoException e) {
       //     LOGGER.error("Error while finding user: ",e);
        } catch (HasherException e) {
       //     LOGGER.error("Couldn't validate: ",e);
        } catch (ValidatorException e){
      //      LOGGER.error(e);
        }
     //   LOGGER.info("account is not valid");
        return false;
    }

    private boolean compareHashes(byte[] hash1, byte[] hash2) {
     /*   boolean isEqual = hash1.length == hash2.length;
        for (int i = 0; i < hash1.length && i < hash2.length; i++) {
            isEqual &= hash1[i] == hash2[i];
        }
        return isEqual;*/
        int diff = hash1.length ^ hash2.length;
        for(int i = 0; i < hash1.length && i < hash2.length; i++)
        {
            diff |= hash1[i] ^ hash2[i];
        }
        return diff == 0;
    }

}
