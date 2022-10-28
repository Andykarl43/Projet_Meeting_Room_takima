import { Component, OnInit } from '@angular/core';
import {Salles} from "../../models/salles.model";
import {Members} from "../../models/members.model";
import {Reservations} from "../../models/reservations.model";
import {Events} from "../../models/events.model";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {ReservationsService} from "../services/reservations.services";
import {SallesService} from "../services/salles.service";
import {MembersService} from "../services/members.service";
import {EventsService} from "../services/events.services";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-update-events',
  templateUrl: './update-events.component.html',
  styleUrls: ['./update-events.component.scss']
})
export class UpdateEventsComponent implements OnInit {

  salles:Salles[];
  members: Members[];
  events: Events[];
  event:any

  constructor(private http: HttpClient, private router: Router, private eventsService: EventsService, private sallesService: SallesService, private membersService: MembersService, private activatedRoute: ActivatedRoute  ) {
    this.events=[];
    this.salles=[];
    this.members=[];
  }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(param=>{
      this.eventsService.detailsEvents(Number(param.get('idEvent'))).subscribe(event=>{
        this.event=event;
        console.log(this.event)
      })
    })
    this.sallesService.getSalles().subscribe(salles => this.salles = salles)
    this.membersService.getMembers().subscribe(members => this.members = members)

  }

  onSubmit(ngForm: NgForm) {
    console.log(ngForm);
    const events = new Events(
      ngForm.form.value.id,
      ngForm.form.value.libelle,
      ngForm.form.value.id_salle,
      ngForm.form.value.id_membre,
      ngForm.form.value.date_debut,
      ngForm.form.value.date_fin,
    )

    this.eventsService.addEvents(events).subscribe();
    setTimeout(()=>this.router.navigateByUrl('/list-events'), 1000)
  }

}
