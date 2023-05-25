package quang.homework.Locators;

public class LearningLocators_XpathTuyetDoi {
     /*
        - xpath tuyệt đối (cách 6-10)
    */

    //1. xpath trang Login
    String email = "//input[@id='email']";
    String password = "//input[@id='password']";
    String rememberme = "//label[normalize-space()='Remember me']";
    String login = "//button[normalize-space()='Login']";
    String forgotPassword = "//a[normalize-space()='Forgot Password?']";

    //2. xpath menu Project
    String tab_project = "//ul[@id='side-menu']//following-sibling::li[@class='menu-item-projects']";
    String new_project = "//a[normalize-space()='New Project']";
    String Grantt = "//a[@class='btn btn-default btn-with-tooltip']";
    String filter = "//button[@class='btn btn-default dropdown-toggle']";
    String not_started = "//div[@class='_filters _hidden_inputs']//div[1]//a";
    String in_progress = "//div[@class='_filters _hidden_inputs']//div[2]//a";
    String on_hold = "//div[@class='_filters _hidden_inputs']//div[3]//a";
    String cancelled = "//div[@class='_filters _hidden_inputs']//div[4]//a";
    String finished = "//div[@class='_filters _hidden_inputs']//div[5]//a";

    //Thế số cuối cùng để ra vị trí từ 1 đến 5 (áp dụng only quantity_page)
    String quantity_page = "//select[@name='DataTables_Table_0_length']//option[1]";

    String export = "//div[@class='dt-buttons btn-group']//button[1]";
    String reload = "//div[@class='dt-buttons btn-group']//button[2]";
    String icon_search = "/div[@class='input-group']/span[@class='input-group-addon']";
    String search = "//div[@class='input-group']/input[@type='search']";

    //2.1 Thanh thead
    String sorting_desc = "//div[@class='table-responsive']//thead//th[@class='sorting sorting_desc']";
    String project_name = "//div[@class='table-responsive']//thead//th[@class='sorting'][1]";
    String customer = "//div[@class='table-responsive']//thead//th[@class='sorting'][2]";
    String tags = "//div[@class='table-responsive']//thead//th[@class='sorting'][3]";
    String start_date = "//div[@class='table-responsive']//thead//th[@class='sorting'][4]";
    String deadline = "//div[@class='table-responsive']//thead//th[@class='sorting'][5]";
    String member = "//div[@class='table-responsive']//thead//th[@class='sorting'][6]";
    String status = "//div[@class='table-responsive']//thead//th[@class='sorting'][7]";

    //2.2 Thanh tbody
    String value_of_sorting_desc = "//div[@class='table-responsive']//tbody//td[1]//a";

        //Trong project name có chứa
    String value_of_project_name = "//div[@class='table-responsive']//tbody//td[2]//a";
    String value_of_project_name_view = "//div[@class='table-responsive']//tbody//td[2]//a";
    String value_of_project_name_copy = "//div[@class='table-responsive']//tbody//td[2]//a[2]";
    String value_of_project_edit = "//div[@class='table-responsive']//tbody//td[2]//a[3]";
    String value_of_project_delete = "//div[@class='table-responsive']//tbody//td[2]//a[4]";

    String value_of_customer = "//div[@class='table-responsive']//tbody//td[3]//a";

        //Trong tag có chứa
    String value_of_tags = "//div[@class='table-responsive']//tbody//td[4]//a";
    String value_of_tags_left = "//div[@class='table-responsive']//tbody//td[4]//div//span[@class='label label-tag tag-id-1']";
    String value_of_tags_right = "//div[@class='table-responsive']//tbody//td[4]//div//span[@class='label label-tag tag-id-3']";

    String value_of_start_date = "//div[@class='table-responsive']//tbody//td[5]";
    String value_of_deadline = "//div[@class='table-responsive']//tbody//td[6]";
    String value_of_member = "//div[@class='table-responsive']//tbody//td[7]//a";
    String value_of_status = "//div[@class='table-responsive']//tbody//td[8]//a";

    //2.3  page
    String previous_page = "//ul[@class=\"pagination\"]//li[@id='DataTables_Table_0_previous']";
    String next_page = "//ul[@class=\"pagination\"]//li[@id='DataTables_Table_0_next']";
    String active_page = "//ul[@class=\"pagination\"]//li[@class='paginate_button active']";

    //3. xpath form của trang New Project
    //3.1 Project Detail
    String label_Add_new_project = "//h4[normalize-space()='Add new project']";

    String button_project = "//ul[@class='nav nav-tabs nav-tabs-horizontal']/descendant::a[normalize-space()='Project']";
    String button_project_setting = "//ul[@class='nav nav-tabs nav-tabs-horizontal']/descendant::a[normalize-space()='Project Settings']";

    String label_ProjectName = "//label[@for='name']";
    String input_ProjectName = "//input[@id='name']";

    String label_Customer = "//label[@for='clientid']";
    String dropdown_Customer = "//div[@class='form-group']//div[@class='dropdown bootstrap-select ajax-search bs3']";

    String checkbox_calculate = "//div[@class='checkbox checkbox-success']//input[@id='progress_from_tasks']";
    String label_calculate = "//div[@class='checkbox checkbox-success']//label[normalize-space()='Calculate progress through tasks']";
    String progress = "//div[@class='form-group']/preceding-sibling::label";

    String lablel_billing_type = "//label[@for='billing_type']";
    String dropdown_billing = "//div[@class='dropdown bootstrap-select bs3']//button[@title='Project Hours']";

    String label_status_of_add = "//label[normalize-space()='Status']";
    String dropdown_status_of_add = "//div[@class='dropdown bootstrap-select bs3']//button[@title='In Progress']";

    String label_rate_per_hour = "//label[normalize-space()='Rate Per Hour']";
    String form_rate_per_hour = "//input[@id='project_rate_per_hour']";

    String label_estimated_hours = "//label[normalize-space()='Estimated Hours']";
    String form_estimated_hours = "//input[@id='estimated_hours']";

    String label_member = "//label[normalize-space()='Members']";
    String dropdown_label_member = "//div[@class='form-group']//div[@class='dropdown bootstrap-select show-tick bs3']";

    String label_starts_date = "//label[@for='start_date']";
    String form_starts_date = "//div[@app-field-wrapper='start_date']//div[@class='input-group date']";

    String deadline_of_add = "//label[normalize-space()='Deadline']";
    String form_deadline_of_add = "//div[@app-field-wrapper='deadline']//div[@class='input-group date']";

    String tags_of_add = "//label[normalize-space()='Tags']";
    String form_tags_of_add = "//li[@class='tagit-new']";

    String label_description = "//p[@class='bold']";
    String body_description = "//body[@data-id='description']";

    String checbox_sendmail = "//input[@id='send_created_email']";
    String label_sendmail = "//label[normalize-space()='Send project created email']";

    String button_save = "//button[normalize-space()='Save']";



}
