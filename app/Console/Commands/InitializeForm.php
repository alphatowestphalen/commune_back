<?php

namespace App\Console\Commands;

use App\Models\Formulaire;
use Illuminate\Console\Command;
use Illuminate\Support\Facades\DB;

class InitializeForm extends Command
{
  /**
   * The name and signature of the console command.
   *
   * @var string
   */
  protected $signature = 'initialize:forms';

  /**
   * The console command description.
   *
   * @var string
   */
  protected $description = 'Initialize all the forms';

  /**
   * Execute the console command.
   */
  public function handle(): void
  {
    $forms = [
      [
        'title' => 'BulletinNaissance',
        'content' => json_encode([
          "title" => 'Bulletin de naissance',
          "logoPosition" => 'right',
          "pages" => [
            [
              "name" => 'page1',
              "elements" => [
                [
                  "type" => 'text',
                  "name" => 'nomPersonne',
                  "title" => 'Nom',
                  "isRequired" => true,
                ],
                [
                  "type" => 'text',
                  "name" => 'prenomsPersonne',
                  "title" => 'Prénoms',
                ],
                [
                  "type" => 'text',
                  "name" => 'dateNaissPersonne',
                  "title" => 'Date de naissance',
                  "isRequired" => true,
                  "inputType" => 'date',
                ],
                [
                  "type" => 'text',
                  "name" => 'lieuNaissPersonne',
                  "title" => 'Lieu de naissance',
                  "isRequired" => true,
                ],
              ],
              "title" => 'Information personnelle',
            ],
            [
              "name" => 'page2',
              "elements" => [
                [
                  "stype" => 'text',
                  "name" => 'nomPere',
                  "title" => 'Nom ( pére )',
                  "isRequired" => true,
                ],
                [
                  "type" => 'text',
                  "name" => 'prenomsPere',
                  "title" => 'Prénoms ( pére )',
                ],
                [
                  "type" => 'text',
                  "name" => 'nomMere',
                  "title" => 'Noms ( mére )',
                  "isRequired" => true,
                ],
                [
                  "type" => 'text',
                  "name" => 'prenomsMere',
                  "title" => 'Prénoms ( mére )',
                ],
              ],
              "title" => 'Information concernant les parents',
            ],
            [
              "name" => 'page3',
              "elements" => [
                [
                  "stype" => 'text',
                  "name" => 'idPremierCopie',
                  "title" => 'Numéro de copie',
                  "isRequired" => true,
                  "inputType" => 'number',
                ],
                [
                  "stype" => 'text',
                  "name" => 'dateCopie',
                  "title" => 'Date de copie',
                  "isRequired" => true,
                  "inputType" => 'date',
                ],
              ],
              "title" => 'Information sur l\'acte',
            ],
          ],
        ])
      ]
    ];

    foreach ($forms as $form) {
      DB::transaction(function () use ($form) {
        $formulaire = new Formulaire($form);
        $formulaire->save();
      });
      DB::commit();
    }

    $this->info("Forms initialized");
  }
}
