import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {SubjectService} from "../../../services/shared/subject.service";
import {ProjectService} from "../../../services/shared/project.service";
import {UserService} from "../../../services/shared/user.service";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-subject-detail',
  templateUrl: './subject-detail.component.html',
  styleUrls: ['./subject-detail.component.scss']
})
export class SubjectDetailComponent implements OnInit {

  @ViewChild('tplDateCell', {static: true}) tplDateCell: TemplateRef<any>;

  // root parameter options
  id: number;
  private sub: any;

  // history table options
  datatable_rows = [];
  columns=[];

  // Dropdown values
  projectOptions = [];
  subjectStatusOptions = [];
  assigneeOptions = [];

  // Form Group nesnesi
  subjectDetailForm: FormGroup;


  constructor(private route: ActivatedRoute,
              private subjectService:SubjectService,
              private projectService : ProjectService,
              private userService : UserService,
              private formBuilder: FormBuilder) { }

  ngOnInit() {


    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];
      this.loadSubjectDetails();
    });


    this.columns = [
      {prop: 'id', name: 'No', maxWidth: 40},
      {prop: 'description', name: 'Description'},
      {prop: 'date', name: 'Subject Date',cellTemplate: this.tplDateCell},
      {prop: 'subjectStatus', name: 'Subject Status'},
      {prop: 'assignee.nameSurname', name: 'Assignee'},
    ];

    // 1- Project DD dolacak
    this.loadProjects();
    // 2- Assignee DD dolacak
    this.loadAssignees();
    // 3- Subject Status DD dolacak
    this.loadSubjectStatuses();
  }

  private loadProjects() { /* projeleri getiriyoruz*/
    this.projectService.getAlls().subscribe(response => {
      this.projectOptions = response;
    })
  }


  private loadAssignees() {  /* userları getiriyoruz*/
    this.userService.getAll().subscribe(response => {
      this.assigneeOptions = response;
    })
  }


  private loadSubjectStatuses() { /* subject statusları getiriyoruz */
    this.subjectService.getAllSubjectStatusess().subscribe(response => {
      this.subjectStatusOptions = response;
    })
  }


  private loadSubjectDetails() {
    this.subjectService.getByIdWithDetails(this.id).subscribe(response => {
      this.subjectDetailForm = this.createSubjectDetailFormGroup(response);
      this.datatable_rows = response['subjectHistories']; // response dan gelen subjectHistories alanını verecegiz..
    });
  }

  createSubjectDetailFormGroup(response) {
    return this.formBuilder.group({
      id: response['id'],
      description: response['description'],
      details: response['details'],
      date: this.fromJsonDate(response['date']),
      subjectStatus: response['subjectStatus'],
      assignee_id: response['assignee']? response['assignee']['id'] : '',
      project_id: response['project'] ? response['project']['id'] : '',
      project_manager: response['project'] && response['project']['managerIds'] ? response['project']['managerIds']['nameSurname']: '',
    });
  }


  saveSubject()
  {
    this.subjectService.updateSubject(this.subjectDetailForm.value).subscribe(response=>{
      this.subjectDetailForm = this.createSubjectDetailFormGroup(response);
      console.log(response);
      this.datatable_rows = response['subjectHistories'];
    });
  }

  // date donusumu
  fromJsonDate(jDate): string {
    const bDate: Date = new Date(jDate);
    return bDate.toISOString().substring(0, 10);
  }
}
