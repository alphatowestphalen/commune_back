<?php

namespace App\Http\Controllers\API;

use App\Http\Controllers\Controller;
use App\Models\Statistique;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;

class StatistiqueController extends Controller
{
    public function index(): JsonResponse
    {
        $dashboards = Statistique::all();
        return  response()->json($dashboards);
    }
}
