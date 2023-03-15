<?php

namespace App\Http\Controllers\API;

use App\Http\Controllers\Controller;
use App\Models\Formulaire;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;

class FormulaireController extends Controller
{
    public function getByTitle(string $title): JsonResponse
    {
        $form = Formulaire::where('title', $title)->first();
        return response()->json(['form' => $form]);
    }
    public function store(Request $request)
    {
        $form = Formulaire::where('title', $request->input('title'))->first();
        if (!$form) {
            $form = new Formulaire(['title' => $request->input('title'), 'content' => $request->input('content')]);
            $form->save();
        } else {
            $form->content = $request->input('content');
            $form->update();
        }
        return response()->json(['form' => $form]);
    }
}
