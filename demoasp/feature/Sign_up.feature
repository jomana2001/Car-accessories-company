Feature:Sign up


  Scenario Outline:trying to signing up with an existing email
    Given that the user is not logged in
    When the information is exist email is "<Email>"
    Then creating an account failed

    Examples:
      | Email                         |
      | jomana.asem.hamayel@gmail.com   |
      | jomanaahamayel@gmail.com      |
      | j.a.a.hamayel21@gmail.com       |


  Scenario:trying to signing up with incorrect email format
    Given that the user is not logged in
    When the information is not formatly correct
    Then creating an account failed


  Scenario Outline:trying to signing up with new account
    Given that the user is not logged in
    When the information is not exist email is not "<Email>"
    Then creating an account successfully

    Examples:
      | Email                         |
       | jomana.asem.hamayel@gmail.com   |
      | jomanaahamayel@gmail.com      |
      | j.a.a.hamayel21@gmail.com       |



