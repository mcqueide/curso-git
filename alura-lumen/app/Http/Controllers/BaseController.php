<?php


namespace App\Http\Controllers;


use Illuminate\Http\Request;

abstract class BaseController
{

    protected $classe;

    public function index()
    {
        return $this->classe::all();
    }

    public function store(Request $request)
    {
        return response()->json($this->classe::create($request->all()), 201);
    }

    public function show(int $id)
    {
        $serie = $this->classe::find($id);

        if (is_null($serie)) {
            return response()->json('', 204);
        }

        return response()->json($serie);
    }

    public function update(int $id, Request $request)
    {
        $serie = $this->classe::find($id);

        if (is_null($serie)) {
            return response()->json([
                'erro' => 'Recurso não encontrado'
            ], 404);
        }

        $serie->fill($request->all());
        $serie->save();

        return $serie;
    }

    public function destroy(int $id)
    {
        $qtdRecursosRemovidos = $this->classe::destroy($id);
        if ($qtdRecursosRemovidos === 0) {
            return response()->json([
                'erro' => 'Recurso não encontrado'
            ], 404);
        }

        return response()->json('', 204);
    }
}
