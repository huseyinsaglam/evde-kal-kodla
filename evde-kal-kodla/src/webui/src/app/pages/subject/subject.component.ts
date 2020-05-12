import {Component, OnInit, TemplateRef} from '@angular/core';
import {SubjectService} from "../../services/shared/subject.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Page} from "../../common/page";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";
import {ProjectService} from "../../services/shared/project.service";

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.scss']
})
export class SubjectComponent implements OnInit {


  modalRef: BsModalRef; /*Diyalogumu bunun ile initilation edecegiz.. */
  page = new Page();
  projectOptions = [];

  subjectForm: FormGroup;

  // pagination bilgilerini tutan propertyler
  rows = [];
  columns = [];
  loadingIndicator = true;
  reorderable = true;

  constructor(private subjectService : SubjectService,
              private modalService: BsModalService,
              private projectService: ProjectService,
              private formBuilder: FormBuilder) {

    this.fetch(data => {
      this.rows = data;
    });
  }

  ngOnInit() {

    this.subjectForm = this.formBuilder.group({
      projectId: [null, [Validators.required]],
      description: [null, [Validators.required]]
    });
    this.loadProjects();
    ({offset: 0});
  }


  // https://www.positronx.io/create-ionic-data-table-with-ngx-datatable/
  fetch(cb) {
    this.subjectService.getAll().subscribe(
      projectData => {

        this.rows = projectData.content;

      }
    )
  }

  // https://valor-software.com/ngx-bootstrap/#/modals
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  private loadProjects() {
    this.projectService.getAlls().subscribe(response => {
      this.projectOptions = response;
    });
  }

  get f() {
    return this.subjectForm.controls
  }
  saveSubject() {

    this.subjectService.createSubject(this.subjectForm.value).subscribe(
      resp => {
        this.subjectForm.reset();
        {offset: 0};
        this.closeAndResetModal();
      }
    );

  }

  closeAndResetModal() {
    this.modalRef.hide();
  }
}
