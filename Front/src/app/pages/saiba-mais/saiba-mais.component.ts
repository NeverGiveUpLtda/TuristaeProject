import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TurismoService } from '../../services/turismo.service';

@Component({
  selector: 'app-saiba-mais',
  templateUrl: './saiba-mais.component.html',
  styleUrls: ['./saiba-mais.component.css']
})
export class SaibaMaisComponent implements OnInit {

  turismo: any = {};

  constructor(private _router: ActivatedRoute, private _turismo: TurismoService) { }

  ngOnInit(): void {
    window.localStorage.setItem("url", "saiba-mais");
    this._turismo.buscarTurismoPorId(Number(this._router.snapshot.paramMap.get('id'))).subscribe((data: any) => {
      this.turismo = data;
      console.log(this.turismo);
    });
  }
}
