Feature: This is scenario outline feature

  Scenario Outline: Test multiple page titles
    Given User navigates to '<url>'
    Then user sees page title '<page_title>'
    Examples:
      | url               | page_title                                                    |
      | http://google.lv  | Google                                                        |
      | http://www.lu.lv  | Latvijas Universitāte                                         |
      | http://www.rtu.lv | Rīgas Tehniskā universitāte \| Inženierzinātņu centrs Baltijā |
