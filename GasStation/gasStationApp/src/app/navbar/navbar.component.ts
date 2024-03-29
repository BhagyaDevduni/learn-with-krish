import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  load_user(){
    this.router.navigate(['user'])
  }

  load_orderStatus(){
    this.router.navigate(['orderStatus'])
  }

  load_home(){
    this.router.navigate(['home'])
  }
  
}
