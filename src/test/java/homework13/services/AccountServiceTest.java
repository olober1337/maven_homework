package homework13.services;

import homework13.dao.AccountDao;
import homework13.dto.AccountDto;
import homework13.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountDao accountDao;

    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        accountService = new AccountService(accountDao);
    }

    @Test
    public void shouldMethodFindAllSuitableAccounts() {
        Account account = new Account();
        account.setClientId(1);
        account.setValue(1000);
        account.setNumber("Number");

        when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));

        List<AccountDto> actualResult = accountService.findAllAccounts();

        assertEquals(1, actualResult.size());
        assertEquals("Number", actualResult.get(0).getNumber());
        assertEquals(1000, actualResult.get(0).getValue());
        assertEquals(1, actualResult.get(0).getClientId());
    }
}