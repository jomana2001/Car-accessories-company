Feature:Login


  Scenario Outline: Valid information
    Given that the user is not logged in
    When the information is valid email is "<Email>" and password is "<Password>"
    And verification code is 12345
    Then user successfully log in

    Examples:
      | Email                         | Password |
      | jomana.hamayel.asem@gmail.com   | 123456   |
      | jomanaahamayel@gmail.com      | 655321   |
      | j.a.a.hamayel21@gmail.com       | 986654   |

  Scenario Outline: Invalid email
    Given that the user is not logged in
    When the email is invalid email is "<Email>" and password is "<Password>"
    Then user failed in log in

    Examples:
      | Email                         | Password |
      | jomana.hamayel.asem@gmail.com   | 123456   |
      | jomanaahamayel@gmail.com      | 655321   |
      | j.a.a.hamayel21@gmail.com       | 986654   |

  Scenario Outline: Invalid password
    Given that the user is not logged in
    When the password is invalid email is "<Email>" and password is "<Password>"
    Then user failed in log in

    Examples:
      | Email                         | Password |
        | jomana.hamayel.asem@gmail.com   | 123456   |
      | jomanaahamayel@gmail.com      | 655321   |
      | j.a.a.hamayel21@gmail.com       | 986654   |


  Scenario Outline: Invalid information
    Given that the user is not logged in
    When the information are invalid email is "<Email>" and password is "<Password>"
    Then user failed in log in
    Examples:
      | Email                         | Password |
       | jomana.hamayel.asem@gmail.com   | 123456   |
      | jomanaahamayel@gmail.com      | 655321   |
      | j.a.a.hamayel21@gmail.com       | 986654   |