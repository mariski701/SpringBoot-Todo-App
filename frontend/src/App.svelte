<script>
	import { onMount } from 'svelte';

	const apiURL = "http://127.0.0.1:8080/api/todo/";
	let data = []
	let text = ''
	
	let currentFilter = 'all';
		
	onMount(async function() {
		const response = await fetch(apiURL + "getTodos");
		data = await response.json();
		console.log(data);
	});

	$: filteredTodos = 
		currentFilter === 'all' ? data : currentFilter === 'completed' ? data.filter(item => item.done) : data.filter(item => !item.done)
	

	async function doPost() {
		const response = await fetch(apiURL + 'addTodo', 
		{
			"method": 'POST',
			"headers": {
				"Content-Type" : "application/json"
			},
			"body": JSON.stringify({
				text : text,
				done : false
			})
		})
		const json = await response.json()
		data = json;
	}

	async function doUpdate(id, done) {
		console.log(id);
		const response = await fetch(apiURL + '/updateTodo/' + id + '/' + done,
		{
			"method" : 'PUT',
			"headers": {
				"Content-Type" : "application/json"
			},
			"body" : JSON.stringify({
				_id : id,
				done : done
			})
		})
		const json = await response.json()
		data = json;
	}

	async function doDelete(id) {
		const res = await fetch(apiURL + 'deleteTodo/' + id,
		{
			"method" : "DELETE"
		})
		const json = await res.json()
		data = json;
	}

	function updateFilter(filter) {
		currentFilter = filter;
	}
	

</script>

<main>
	<div class="container">
		<div class="text-center jumbotron">
			<h1>SvelteTODO</h1>
		</div>
	
		<div align="center">
			<div class="text-center col-sm-4 col-sm-offset-4">
				<ul id="filters" class="list-inline">
					<li class="list-inline-item">
						<a class="btn btn-primary" href={null} on:click={()=>updateFilter('all')}>All</a>
					</li>
					<li class="list-inline-item">
						<a class="btn btn-primary" href={null} on:click={()=>updateFilter('active')}>Active</a>
					</li>
					<li class="list-inline-item">
						<a  class="btn btn-primary" href={null} on:click={()=>updateFilter('completed')} >Finished</a>
					</li>
				</ul>
			</div>
		</div>
		{#each filteredTodos as item}
			<div  class="row" align="center">
				<div class="text-center col-sm-4 col-sm-offset-4">
					<input type="checkbox" bind:checked={item.done} on:change={doUpdate(item.id,item.done)}>{item.text}<button on:click={doDelete(item.id)}><img src="kosz.jpg" width="20" height="20"/></button>
				</div>
			</div>
		{/each}
		<div class="row" id="todo-form" align="center">
			<div class="text-center col-sm-8 col-sm-offset-2">
				<form>
					<input bind:value={text} class="text-center form-control input-lg" placeholder="What are you going to do?"/>
					<button class="btn btn-primary btn-lg" type="button" on:click={doPost}>Add Todo</button>
				</form>
			</div>
		</div>
	</div>
</main>

<style>
	@import url("//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css");

	html {
        overflow-y: scroll;
    }
    body {
        padding-top: 50px;
    }
    #todo-list {
        margin-bottom: 30px;
    }
    #todo-form {
        margin-bottom: 50px;
    }
</style>