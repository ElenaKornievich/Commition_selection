package com.kornievich.selectionCommition.command;

import com.kornievich.selectionCommition.command.impl.admin.*;
import com.kornievich.selectionCommition.command.impl.common.*;

public enum CommandEnum {
    LOGIN (LoginCommand.getInstance()),
    LOGOUT (LogoutCommand.getInstance()),
    REGISTRATION(RegistrationCommand.getInstance()),
    MAIN(MainCommand.getInstance()),
    CONTACT(ContactCommand.getInstance()),
    QUEUE(QueueCommand.getInstance()),
    FACULTY(FacultyCommand.getInstance()),
    MMF(MMFCommand.getInstance()),
    CHANGE(ChangeCommand.getInstance()),
    CHANGESPECIALITY(ChangeSpeciality.getInstance()),
    ABOUT(AboutCommand.getInstance()),
    TEST(TestCommand.getInstance()),
    CHANGEENTRANT(ChangeEntrantCommand.getInstance()),
    CHANGEBUTTON(ChangeButtonCommand.getInstance()),
    CHANGEADMIN(ChangeAdminCommand.getInstance()),
    ADMINPANEL(AdminPanelCommand.getInstance()),
    DELETEENTRANT(DeleteEntrantCommand.getInstance()),
    CREATEADMIN(CreateAdminCommand.getInstance()),
    CREATEFACULTY(CreateFacultyCommand.getInstance()),
    CREATESUBJECT(CreateSubjectCommand.getInstance()),
    CREATESPECIALITY(CreateSpecialityCommand.getInstance()),
    DELETEFACULTY(DeleteFacultyCommand.getInstance()),
    DELETESPECIALITY(DeleteSpecialityCommand.getInstance()),
    DELETESUBJECT(DeleteSubjectCommand.getInstance()),
    CHANGEFACULTY(CreateFacultyCommand.getInstance()),
    CHANGESUBJECT(CreateSubjectCommand.getInstance());


    BaseCommand command;
    CommandEnum(BaseCommand instance){
        this.command = instance;
    }
    public BaseCommand getCurrentCommand(){
        return command;
    }
}
