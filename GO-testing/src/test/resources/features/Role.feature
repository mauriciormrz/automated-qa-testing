Feature: Go Users
  As a Admin or HR of Ventura Travel, I want to edit the information of the vMembers.

  Background:
    Given that the Admin navigates to the homepage of the New GO platform
    When he enters his user 'mauricio.ramirez@venturatravel.org' and password 'M@uricio69'


  @AddRole
  Scenario Outline: Add a role to a Go User
    Given that the Admin edits the '<go user>' info
    When he adds a new role '<role>'
    Then he verifies the new number of roles

    Examples:
      | New GO   | go user           | role   |
      | Platform | Franziska Umlauft | TESTER |
      | Platform | Franziska Umlauft | ADMIN  |


  @DeleteRole
  Scenario Outline: Delete a role to a vMember
    Given that the Admin edits the '<go user>' info
    When he deletes the role '<role>'
    Then he verifies the new number of roles

    Examples:
      | New GO   | go user           | role  |
      | Platform | Franziska Umlauft | TESTER |

