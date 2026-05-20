# UPI App

Small console-based UPI payment app with login, balance check, send money, and PIN change.

## Entry Point

Run the app with:

```bash
mvn exec:java -Dexec.mainClass=com.vinayprabhakarx.exceptions.upi.Main
```

## Features

- Login with username and PIN
- Username validation before PIN entry
- Recipient UPI validation before payment
- Check balance
- Send money
- Change PIN
- Session termination after 3 incorrect PIN attempts

## Sample Users

- `vinay` -> `vinay@upi` -> PIN `1234`
- `kunal` -> `kunal@upi` -> PIN `4321`
- `rahul` -> `rahul@upi` -> PIN `5678`

## Package Structure

- `Main.java` - application start class
- `LoginService.java` - login flow
- `PaymentApp.java` - session menu and user interaction
- `UPIServer.java` - validation and transaction logic
- `UpiUser.java` / `UpiUserDatabase.java` - user model and in-memory data
- `exception/` - custom exception classes

## File Movement Flow

```text
Main
  |
  v
PaymentApp
  |
  +--> LoginService
  |      |
  |      v
  |    UPIServer
  |      |
  |      +--> UpiUserDatabase
  |      |      |
  |      |      v
  |      |    UpiUser
  |      |
  |      +--> exception/
  |             |
  |             +--> AuthenticationException
  |             +--> InvalidPinException
  |             +--> InvalidAmountException
  |             +--> InvalidUpiFormatException
  |             +--> InvalidUsernameFormatException
  |             +--> InsufficientBalanceException
  |             +--> UpiNotFoundException
  |
  +--> Send Money Flow
  |      |
  |      v
  |    UPIServer --> UpiUserDatabase --> UpiUser
  |
  +--> Check Balance Flow
  |      |
  |      v
  |    UPIServer --> UpiUser
  |
  +--> Change PIN Flow
         |
         v
       UPIServer --> UpiUser
```

## Working Flow

1. User starts the app from `Main`.
2. App asks for username.
3. Username is checked immediately for:
   - valid username format
   - user availability in database
4. If username is valid, app asks for login PIN.
5. If PIN is wrong 3 times, session is terminated.
6. After successful login, menu is shown:
   - Send Money
   - Check Balance
   - Change PIN
   - Terminate Session
7. For Send Money:
   - recipient UPI is entered
   - UPI format is checked immediately
   - recipient availability is checked immediately
   - amount is entered
   - PIN is entered for confirmation
   - after 3 wrong PIN attempts, session is terminated
   - if valid, payment is processed
8. For Check Balance:
   - current logged-in user balance is displayed
9. For Change PIN:
   - current PIN, new PIN, and confirm PIN are entered
   - after 3 wrong current PIN attempts, session is terminated
   - if valid, PIN is updated
10. User can terminate the session from the menu at any time.
