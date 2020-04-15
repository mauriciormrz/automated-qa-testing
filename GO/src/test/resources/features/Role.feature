Feature: Go Users
  As a Admin or HR of Ventura Travel, I want to edit the information of the vMembers.

  Background:
    Given the TS 'Mauricio Ramirez Restrepo' logs into the 'https://go-staging.venturatravel.org' GO platform with user 'mauricio.ramirez@venturatravel.org' and password 'M@uricio69'


  @AddRole
  Scenario Outline: Add a role to a vMember
    Given the Admin edits the '<vMember>' info
    When add the role '<role>' and see the message 'Record updated successfully'
    Then the Admin can see the increase in the number of vMember roles

    Examples:
      | New GO   | vMember           | role   |
      | Platform | Franziska Umlauft | TESTER |
      | Platform | Franziska Umlauft | ADMIN  |

  @DeleteRole
  Scenario Outline: Delete a role to a vMember
    Given the Admin edits the '<vMember>' info
    When delete the '<role>' and see the message 'Record updated successfully'
    Then the Admin can see the decrease in the number of vMember roles

    Examples:
      | New GO   | vMember           | role  |
      | Platform | Franziska Umlauft | ADMIN |