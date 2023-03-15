<?php

namespace App\Console\Commands;

use App\Models\Statistique;
use Illuminate\Console\Command;

class AddStatistique extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'dashboard:add';

    /**
     * The console command description.
     *
     * @var string
     */
    protected $description = 'This command store the dashboard UUID in the database';

    /**
     * Execute the console command.
     */
    public function handle(): void
    {
        $uuid = $this->ask("Entrer l'UUID du dashboard depuis Metabase");

        $statistique = Statistique::create([
            'app_uuid' => $uuid
        ]);
        $statistique->save();

        $this->info("UUID " . $uuid . " enregistré avec succès");
    }
}
